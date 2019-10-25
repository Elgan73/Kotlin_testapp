package com.stark.test65apps.presentation.persons

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.Domain.Interactors.GetAllPersonsInteractor
import com.stark.test65apps.Domain.Interactors.LoadDataInteractor
import com.stark.test65apps.Navigation.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Entity

@InjectViewState
class PersonsPresenter: MvpPresenter<PersonsView>() {


    fun onItemClick(personItem: PersonItem) {
        val bundle = Bundle()
        bundle.putInt(AppsConstants.DETAILS_BUNDLE_KEY_ID, personItem.specialty_id)
        App.fragmentRouter.navigateTo(Screens.FRAGMENTS.DETAIL_FRAGMENT, bundle)
    }

    fun getData() {
        GetAllPersonsInteractor.execute {
            CoroutineScope(Dispatchers.Main).launch {
                viewState.setAdapterData(it)
            }
        }
    }


}