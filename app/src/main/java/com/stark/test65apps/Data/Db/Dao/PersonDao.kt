package com.stark.test65apps.Data.Db.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity


@Dao
interface PersonDao {
    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME}")
    fun getAllPerson():List<PersonEntity>

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME}")
    fun getAllPersonBySpec(): List<PersonEntity>

    @Insert
    fun insertAll(person: List<PersonEntity>)

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME} WHERE id = :id")
    fun getPersonById(id: Int): List<PersonEntity>

    @Query("SELECT * FROM ${AppsConstants.TABLE_NAME} WHERE specialty_name = :spec")
    fun getAllSpec(spec: Int): List<PersonEntity>
}