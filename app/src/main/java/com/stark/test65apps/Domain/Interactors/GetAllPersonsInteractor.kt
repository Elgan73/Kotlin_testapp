package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

object GetAllPersonsInteractor {

    fun execute(onComplete: (List<PersonItem>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = App.personRepository.getAllPerson()

            try {
                onComplete.invoke(response.orEmpty())

            } catch (e: Exception) {
                Log.d("Logs", "GetAllPersonsInteractor exception: $e")
            }

        }
    }

}