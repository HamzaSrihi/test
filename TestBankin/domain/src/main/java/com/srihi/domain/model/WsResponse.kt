package com.srihi.domain.model

import io.reactivex.Observable

data class WsResponse(
    val resources: Observable<List<Category>>,
    val pagination: Pagination
)