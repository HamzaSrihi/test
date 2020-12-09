package com.srihi.domain.usecase

import com.srihi.domain.model.WsResponse
import io.reactivex.Observable

interface GetCategoryRepository {

    fun getCategories(): Observable<WsResponse>
}