package com.stark.test65apps.presentation.persons

import android.os.Bundle
import android.util.Log
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
import org.joda.time.LocalDate
import org.joda.time.Years
import org.joda.time.format.DateTimeFormat
import org.w3c.dom.Entity
import java.text.SimpleDateFormat
import kotlin.coroutines.CoroutineContext

@InjectViewState
class PersonsPresenter : MvpPresenter<PersonsView>() {

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
                Log.d("CoroutinesData", "$it")
                viewState.setAdapterData(it)
            }
        }
    }

    fun onItemClick(personItem: PersonItem) {
        val bundle = Bundle()
        bundle.putInt(AppsConstants.DETAILS_BUNDLE_KEY_ID, personItem.id)
        App.fragmentRouter.replace(Screens.FRAGMENTS.DETAIL_FRAGMENT, bundle)
    }

    fun stringName(string: String): String {
        var nPers = string
        nPers = nPers.substring(0, 1).toUpperCase() + nPers.substring(1).toLowerCase()

        return nPers
    }

    fun age(string: String): String {
        val formatter = DateTimeFormat.forPattern("dd.MM.yyyy")
        val past = formatter.parseLocalDate(string)
        val now = LocalDate.now()
        val age = Years.yearsBetween(past, now)

        return age.years.toString()
    }

    fun parseReversDate(string: String): String {
        val reversDatePattern = SimpleDateFormat("yyyy-MM-dd")
        val correctDatePattern = SimpleDateFormat("dd.MM.yyyy")
        val parseD = reversDatePattern.parse(string)
        val result = correctDatePattern.format(parseD)

        return result
    }

    fun parseCorrectDate(string: String): String {
        val correctDatePattern = SimpleDateFormat("dd-MM-yyyy")
        val correctDate = SimpleDateFormat("dd.MM.yyyy")
        val parseD = correctDatePattern.parse(string)
        val result = correctDate.format(parseD)

        return result
    }


}