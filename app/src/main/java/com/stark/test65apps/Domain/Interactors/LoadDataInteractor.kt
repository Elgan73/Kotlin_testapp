package com.stark.test65apps.Domain.Interactors

import android.util.Log
import com.stark.test65apps.App
import com.stark.test65apps.Domain.Dataclasess.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.lang.Exception

object LoadDataInteractor {
    fun execute(onComplete: ((Person) -> Unit)?) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Logs", "before start")
            val response = App.retrofitNetwork.personApi.loadData().await()
            Log.v("Logs", "response: $response")

            try {
                onComplete?.invoke(response.body()!!)




            } catch (e: Exception) {
                Log.d("LogsError", "LoadDataInteractor error: $e")
            }


        }
    }
}