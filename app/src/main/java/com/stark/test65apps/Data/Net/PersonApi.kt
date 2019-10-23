package com.stark.test65apps.Data.Net

import com.stark.test65apps.Domain.Dataclasess.PersonModel
import com.stark.test65apps.Domain.Dataclasess.PersonResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PersonApi {

    @GET("raw/master/testTask.json/")
    fun loadData(): Deferred<Response<PersonResponse>>?
}