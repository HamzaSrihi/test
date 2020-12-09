package com.srihi.domain.usecase

import com.srihi.domain.model.WsResponse
import io.reactivex.Observable

class GetCategoriesUseCase(private val getCategoryRepository: GetCategoryRepository) {
    fun execute(): Observable<WsResponse> = getCategoryRepository.getCategories()
}