package com.stark.test65apps.presentation.details

import com.arellomobile.mvp.MvpView
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.presentation.persons.PersonItem

interface DetailPersonView: MvpView {
    fun setData(data: PersonItem)
}