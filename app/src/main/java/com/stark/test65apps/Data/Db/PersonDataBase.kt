package com.stark.test65apps.Data.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Dao.PersonDao
import com.stark.test65apps.Data.Db.Entity.PersonEntity


@Database(entities = [PersonEntity::class], version = 1, exportSchema = false)
abstract class PersonDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        private var INSTANCE: PersonDataBase? = null

        fun getInstance(context: Context): PersonDataBase? {
            if(INSTANCE == null) {
                synchronized(PersonDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        PersonDataBase::class.java, AppsConstants.TABLE_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}