package com.stark.test65apps.Domain.Dataclasess

data class Person(
    val response: List<Response>
)

data class Response(
    val avatr_url: String,
    val birthday: String? = null,
    val f_name: String,
    val l_name: String,
    val specialty: List<Specialty>
)

data class Specialty(
    val name: String,
    val specialty_id: Int
)
