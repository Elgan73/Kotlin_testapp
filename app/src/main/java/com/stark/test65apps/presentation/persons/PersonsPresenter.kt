package com.stark.test65apps.presentation.persons

import android.os.Bundle
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.Domain.Dataclasess.PersonModel
import com.stark.test65apps.Domain.Interactors.GetAllPersonsInteractor
import com.stark.test65apps.Domain.Interactors.LoadDataInteractor
import com.stark.test65apps.Navigation.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonsPresenter: MvpPresenter<PersonsView>() {

    private fun loadPersons() {
        LoadDataInteractor.execute {
            App.personRepository.getAllPerson()
            getData()
        }
    }

    fun getData() {
        GetAllPersonsInteractor.execute {
            if (it.isEmpty()) {
                loadPersons()
            } else setData(it)
        }
    }

    private fun setData(data: List<PersonItem>) {
        CoroutineScope(Dispatchers.Main).launch {
            viewState.setAdapterData(data)
        }
    }

    fun onItemClick(personItem: PersonEntity) {
        val bundle = Bundle()
        bundle.putInt(AppsConstants.DETAILS_BUNDLE_KEY_ID, personItem.id!!)
        App.fragmentRouter.navigateTo(Screens.FRAGMENTS.DETAIL_FRAGMENT, bundle)
    }
}