package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

object GetPersonByIdInteractor {

    fun execute(id: Int, onComplete: (PersonItem) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = App.personRepository.getPersonById(id)

            try {
                onComplete.invoke(response)
            } catch (e: Exception) {
                Log.d("Logs", "GetPersonByIdInteractor exception: $e")
            }
        }

    }


}