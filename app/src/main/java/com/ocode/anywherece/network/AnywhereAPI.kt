package com.ocode.anywherece.network

import com.ocode.anywherece.model.GetWireResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface AnywhereAPI {
    @GET()
    suspend fun getWire(
        @Query("q") query : String = "the+wire+characters&format=json",
        @Query("format") format : String = "json"
    ): GetWireResponse
}