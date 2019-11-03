package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull
import java.lang.Exception

object GetPersonByIdInteractor {

    fun execute(id: Int, onComplete: (PersonItem) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = App.personRepository.getOneById(id)
                if (response.isNullOrEmpty()) {
                    Log.d("respLogs", "Response is empty")
                } else {
                    response.forEach {
                        onComplete.invoke(it)
                    }
                }
            } catch (e: Exception) {
                Log.d("Logs", "GetPersonByIdInteractor exception: $e")
            }
        }
    }
}