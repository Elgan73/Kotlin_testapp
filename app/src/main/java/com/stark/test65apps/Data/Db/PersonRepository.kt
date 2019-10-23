package com.stark.test65apps.Data.Db

import com.stark.test65apps.App
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.Domain.Dataclasess.PersonModel
import com.stark.test65apps.Domain.Dataclasess.PersonResponse
import com.stark.test65apps.Domain.Dataclasess.Spec
import com.stark.test65apps.presentation.persons.PersonItem

object PersonRepository {

    fun getAllPerson(): List<PersonItem>? = App.personDataBase?.personDao()?.getAllPerson()?.map {
        PersonItem(
            f_name = it.f_name,
            l_name = it.l_name,
            birthday = it.birthday,
            avatr_url = it.avatr_url,
            specialty_name = it.specialty_name,
            specialty_id = it.specialty_id




        )
    }

    fun savedAllData(data: List<PersonModel>) = App.personDataBase?.personDao()?.insertAll(data.map {
        PersonEntity(

            f_name = it.f_name,
            l_name = it.l_name,
            birthday = it.birthday,
            avatr_url = it.avatr_url,
            specialty_id = it.specialty[0].specialty_id,
            specialty_name = it.specialty[0].name




        )
    })

    fun getAllPersonBySpec(spec: Int): List<PersonItem>? = App.personDataBase?.personDao()?.getAllPersonBySpec(spec)?.map {
        PersonItem(
            f_name = it.f_name,
            l_name = it.l_name,
            birthday = it.birthday,
            avatr_url = it.avatr_url,
            specialty_id = it.specialty_id,
            specialty_name = it.specialty_name



        )
    }

    fun getSpec(): List<PersonItem>? = App.personDataBase?.personDao()?.getAllSpec()?.map {
        PersonItem(
            f_name = it.f_name,
            l_name = it.l_name,
            birthday = it.birthday,
            avatr_url = it.avatr_url,
            specialty_id = it.specialty_id,
            specialty_name = it.specialty_name
        )
    }

    fun getPersonById(id: Int): List<PersonItem>? = App.personDataBase?.personDao()?.getPersonById(id)?.map {
        PersonItem(

            f_name = it.f_name,
            l_name = it.l_name,
            birthday = it.birthday,
            avatr_url = it.avatr_url,
            specialty_id = it.specialty_id,
            specialty_name = it.specialty_name
        )
    }


}