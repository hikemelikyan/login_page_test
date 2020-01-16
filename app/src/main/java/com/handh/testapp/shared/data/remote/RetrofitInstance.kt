package com.handh.testapp.shared.data.remote

import com.handh.testapp.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var instance: Retrofit? = null

    fun getInstance(): Retrofit {
        return if (instance != null) {
            instance!!
        } else {
            instance = Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            instance!!
        }
    }
}