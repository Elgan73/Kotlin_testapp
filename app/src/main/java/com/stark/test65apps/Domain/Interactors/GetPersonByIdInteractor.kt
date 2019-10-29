package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull
import java.lang.Exception

object GetPersonByIdInteractor {

    fun execute(id: Int, onComplete: (PersonItem) -> Unit) {

        CoroutineScope(Dispatchers.Default).launch {
            val response = App.personRepository.getOneById(id)
            try {

                onComplete.invoke(response!![0])

            } catch (e: Exception) {
                Log.d("Logs", "GetPersonByIdInteractor exception: $e")
            }
        }

    }


}