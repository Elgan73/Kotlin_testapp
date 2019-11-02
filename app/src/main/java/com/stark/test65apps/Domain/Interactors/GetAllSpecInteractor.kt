package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

object GetAllSpecInteractor {

    fun execute(onComplete: (List<PersonItem>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = App.personRepository.getSpec()

            try {
                if (!response.isNullOrEmpty()) {
                    onComplete.invoke(response)
                } else {
                    Log.d("responseSpecInt", "$response")
                }

            } catch (e: Exception) {
                Log.d("Logs", "GetAllSpecInteractor exception: $e")
            }
        }
    }
}