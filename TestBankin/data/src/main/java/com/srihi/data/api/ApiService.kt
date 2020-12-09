package com.srihi.data.api


import com.srihi.domain.model.WsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("categories.json")
    fun getCategoryList(): Observable<WsResponse>
}