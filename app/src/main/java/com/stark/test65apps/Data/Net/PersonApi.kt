package com.stark.test65apps.Data.Net

import com.stark.test65apps.Domain.Dataclasess.Person
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PersonApi {

    @GET(".")
    fun loadData(): Deferred<Response<Person>>
}