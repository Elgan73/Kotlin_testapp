package com.stark.test65apps.Data.Db.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stark.test65apps.AppsConstants

@Entity(tableName = AppsConstants.TABLE_NAME)
data class PersonEntity (
    @PrimaryKey(autoGenerate = true) val _id: Int,
    @ColumnInfo(name = "f_name")val f_name: String,
    @ColumnInfo(name = "l_name")val l_name: String,
    @ColumnInfo(name = "birthday")val birthday: String?,
    @ColumnInfo(name = "avatr_url")val avatr_url: String?,
    @ColumnInfo(name = "specialty_id")val specialty_id: Int,
    @ColumnInfo(name = "specialty_name")val specialty_name: String
)
