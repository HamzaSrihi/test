package com.srihi.data.db.repository

import android.util.Log
import com.srihi.data.api.ApiService
import com.srihi.data.db.dao.CategoryDao
import com.srihi.data.db.mapCategoryToEntities
import com.srihi.data.db.mapEntitiesToData
import com.srihi.domain.model.Category
import com.srihi.domain.model.WsResponse
import com.srihi.domain.usecase.GetCategoryRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.stream.Collectors.toList

class CategoryRepository(
    private val apiService: ApiService,
    private val categoryDao: CategoryDao,
    var categories: List<Category>

) : GetCategoryRepository {

    override fun getCategories(): Observable<WsResponse> {
        return apiService.getCategoryList().onErrorResumeNext(loadParentCategories())
            .doOnNext {
                storeCategories(it)
            }.doOnComplete {
                loadParentCategories()
            }

    }

    private fun loadParentCategories() =
        categoryDao.getParentCategories().map { mapEntitiesToData(it) }

    private fun storeCategories(wsResponse: WsResponse) = Observable
        .fromCallable {
            categoryDao.insertCategories(
                categories = mapCategoryToEntities(java.util.observable.toList(wsResponse.resources))
            )
        }
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .subscribe {
            Log.d(
                "StationRepository",
                "Inserted ${categories.size} stations from API in DB..."
            )

        }


}


