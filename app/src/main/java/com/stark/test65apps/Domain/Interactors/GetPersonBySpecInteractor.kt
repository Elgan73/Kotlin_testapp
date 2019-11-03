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
            try {
                val response = App.personRepository.getAllPersonBySpec(spec)
                if(response.isNullOrEmpty()) {
                    Log.d("Response is Empty", "$response")
                } else {
                        onComplete.invoke(response)
                    Log.d("Response!!!!!!!", "$response")

                }
            } catch (e: Exception) {
            Log.d("Logs", "GetAllPersonBySpecInterractor exception: $e")
            }

        }
    }
}