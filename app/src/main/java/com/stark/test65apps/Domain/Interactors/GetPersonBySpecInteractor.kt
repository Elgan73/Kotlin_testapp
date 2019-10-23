package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object GetPersonBySpecInteractor {

    fun execute(spec: Int, onComplete: (List<PersonItem>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = App.personRepository.getAllPersonBySpec(spec)

            try {
                onComplete.invoke(response.orEmpty())
            } catch (e: Exception) {
            Log.d("Logs", "GetAllPersonBySpecInterractor exception: $e")
            }

        }
    }
}