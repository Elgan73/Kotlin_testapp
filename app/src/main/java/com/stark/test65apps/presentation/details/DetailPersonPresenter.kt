package com.stark.test65apps.presentation.details

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.Domain.Interactors.GetPersonByIdInteractor
import kotlinx.coroutines.*
import org.joda.time.LocalDate
import org.joda.time.Years
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat

@InjectViewState
class DetailPersonPresenter : MvpPresenter<DetailPersonView>() {

    fun loadPersonById(id: Int) {
        GetPersonByIdInteractor.execute(id) {
            CoroutineScope(Dispatchers.Main).launch {
                viewState.setData(it)
            }
        }
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
        val correctDate = SimpleDateFormat("dd-MM-yyyy")
        val date = SimpleDateFormat("dd.MM.yyyy")
        val parseD = correctDate.parse(string)
        val result = date.format(parseD)

        return result
    }
}