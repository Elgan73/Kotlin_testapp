package com.stark.test65apps.Domain.Dataclasess

class PersonResponse(
    val responseData : List<PersonModel>
)

class PersonModel(
    var f_name : String,
    var l_name : String,
    var birthday : String,
    var avatr_url : String,
    var specialty : List<Spec>

)

class Spec (
    val specialty_id: Int,
    val name: String
)

