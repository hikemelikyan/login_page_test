package com.handh.testapp.shared.data.remote

import com.handh.testapp.model.All
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IMainService {
    @GET("data/2.5/weather")
    suspend fun testCallAsync(
        @Query("lat") lat: String,
        @Query("lon") lng: String,
        @Query("appid") APP_ID: String,
        @Query("units") units: String
    ): Response<All>
}