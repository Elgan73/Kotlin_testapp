package com.stark.test65apps.presentation.spec

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Domain.Interactors.GetAllSpecInteractor
import com.stark.test65apps.Domain.Interactors.GetPersonBySpecInteractor
import com.stark.test65apps.Domain.Interactors.LoadDataInteractor
import com.stark.test65apps.Navigation.Screens
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@InjectViewState
class SpecPresenter: MvpPresenter<SpecView>() {

    private fun loadData() {
        LoadDataInteractor.execute {
            App.personRepository.savedAllData(it)
            getData()
        }
    }

    fun getData() {
        GetAllSpecInteractor.execute() {
            if (it.isEmpty()) {
                loadData()
            } else setData(it)
        }
    }

    private fun setData(data: List<PersonItem>) {
        CoroutineScope(Dispatchers.Main).launch {
            viewState.setAdapterData(data)
        }
    }

    fun onItemClick(personItem: PersonItem) {
        val bundle = Bundle()
        bundle.putInt(AppsConstants.DETAILS_BUNDLE_KEY_ID, personItem.specialty_id)
        App.fragmentRouter.replace(Screens.FRAGMENTS.PERSONS_FRAGMENT, bundle)
    }
}