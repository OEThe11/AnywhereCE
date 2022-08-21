package com.ocode.anywherece.network

import com.ocode.anywherece.model.GetAnyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface AnywhereAPI {
    @GET(".")
    suspend fun getAnyInfo(
        @Query("q") query : String = "the+wire+characters&format=json",
        @Query("format") format : String = "json"
    ): Response<GetAnyResponse>
}