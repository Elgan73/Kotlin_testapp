package com.stark.test65apps.presentation.persons

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface PersonsView: MvpView {
    fun setAdapterData(data: List<PersonItem>)
}