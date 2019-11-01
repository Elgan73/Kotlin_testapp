package com.stark.test65apps.presentation.persons


data class PersonItem(
    var id : Int,
    var f_name : String,
    var l_name : String,
    var birthday : String? = null,
    var avatr_url : String? = null,
    var specialty_id : Int,
    var specialty_name : String
)