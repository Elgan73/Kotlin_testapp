package com.stark.test65apps.Data.Net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stark.test65apps.AppsConstants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitNetwork {

    private fun retrofit() = Retrofit.Builder()
        .baseUrl(AppsConstants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val personApi : PersonApi = retrofit().create(PersonApi::class.java)
}