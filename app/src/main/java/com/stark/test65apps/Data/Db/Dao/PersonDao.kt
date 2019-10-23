package com.stark.test65apps.Data.Db.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.Domain.Dataclasess.PersonModel
import com.stark.test65apps.Domain.Dataclasess.PersonResponse
import com.stark.test65apps.Domain.Dataclasess.Spec


@Dao
interface PersonDao {
    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME}")
    fun getAllPerson():List<PersonEntity>

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME} where specialty_id = :spec")
    fun getAllPersonBySpec(spec: Int): List<PersonEntity>

    @Insert
    fun insertAll(person: List<PersonEntity>)

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME} WHERE id = :id")
    fun getPersonById(id: Int): List<PersonEntity>

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME}")
    fun getAllSpec(): List<PersonEntity>
}