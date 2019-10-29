package com.stark.test65apps.presentation.persons

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Domain.Interactors.GetAllPersonsInteractor
import com.stark.test65apps.Domain.Interactors.GetPersonBySpecInteractor
import com.stark.test65apps.Navigation.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Entity
import java.text.SimpleDateFormat

@InjectViewState
class PersonsPresenter: MvpPresenter<PersonsView>() {

    fun getData() {
        GetAllPersonsInteractor.execute {
            CoroutineScope(Dispatchers.Main).launch {
                viewState.setAdapterData(it)
            }
        }
    }

    fun getPerSpecData(spec: Int) {
        GetPersonBySpecInteractor.execute(spec) {
            CoroutineScope(Dispatchers.Main).launch {
                viewState.setAdapterData(it)
            }
        }
    }

    fun onItemClick(personItem: PersonItem) {
        val bundle = Bundle()
        bundle.putInt(AppsConstants.DETAILS_BUNDLE_KEY_ID, personItem.id)
        App.fragmentRouter.replace(Screens.FRAGMENTS.DETAIL_FRAGMENT, bundle)
    }


}