package com.stark.test65apps.presentation.details

import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.Domain.Interactors.GetPersonByIdInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailPersonPresenter : MvpPresenter<DetailPersonView>() {

    fun loadPersonById(_id: Int) {
        GetPersonByIdInteractor.execute(_id) {
            CoroutineScope(Dispatchers.Main).launch {
                viewState.setData(it[0])
            }
        }
    }
}