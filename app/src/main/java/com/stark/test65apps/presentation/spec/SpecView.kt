package com.stark.test65apps.presentation.spec

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.presentation.persons.PersonItem

@StateStrategyType(SkipStrategy::class)
interface SpecView : MvpView {
    fun setAdapterData(data: List<Int>)
    fun showMessage(error: String)
}