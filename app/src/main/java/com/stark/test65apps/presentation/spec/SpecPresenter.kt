package com.stark.test65apps.presentation.spec

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Domain.Interactors.GetAllSpecInteractor
import com.stark.test65apps.Domain.Interactors.LoadDataInteractor
import com.stark.test65apps.Navigation.Screens
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

@InjectViewState
class SpecPresenter : MvpPresenter<SpecView>() {

    private val personItems = mutableListOf<PersonItem>()

    private fun loadData() {
        LoadDataInteractor.execute {
            App.personRepository.savedAllData(it)
            getData()
        }
    }

    fun getData() {
        GetAllSpecInteractor.execute {
            if (it.isEmpty()) {
                loadData()
            } else {
            }
            setData(it)
        }
    }

    private fun setData(data: List<PersonItem>) {
        personItems.addAll(data)
        CoroutineScope(Dispatchers.Main).launch {
            val idList = mutableListOf<String>()
            data.forEach { item ->
                if (!idList.contains(item.specialty_name)) {
                    idList.add(item.specialty_name)
                }
            }
            viewState.setAdapterData(idList)
        }
    }

    fun onItemClick(id: String) {
        try {
            val bundle = Bundle()
            bundle.putString(AppsConstants.PERSON_BY_SPEC, id)
            App.fragmentRouter.replace(Screens.FRAGMENTS.PERSONS_FRAGMENT, bundle)
            Log.d("Bundle", "$id")
        } catch (e: Exception) {
            Log.d("Exception", "$e")
        }


//        personItems.filter { personItem ->
//            personItem.specialty_id == id
//        }
    }
}