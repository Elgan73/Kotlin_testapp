package com.stark.test65apps.presentation.spec

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
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
    private var spec = 101

    private fun loadData(spec: Int) {
        LoadDataInteractor.execute {
            App.personRepository.savedAllData(it)
            getData(spec)
        }
    }

    fun getData(spec: Int) {
        GetAllSpecInteractor.execute(spec) {
            if (it.isEmpty()) {
                loadData(spec)
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