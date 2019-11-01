package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object GetPersonBySpecInteractor {

    fun execute(spec: String, onComplete: (List<PersonItem>) -> Unit) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val response = App.personRepository.getAllPersonBySpec(spec)
                if(response.isNullOrEmpty()) {
                    Log.d("Response", "$response")
                } else {
                        onComplete.invoke(response)

                }
            } catch (e: Exception) {
            Log.d("Logs", "GetAllPersonBySpecInterractor exception: $e")
            }

        }
    }
}