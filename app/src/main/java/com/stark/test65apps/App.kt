package com.stark.test65apps

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.stark.test65apps.Data.Db.PersonDataBase
import com.stark.test65apps.Data.Db.PersonRepository
import com.stark.test65apps.Data.Net.RetrofitNetwork
import com.stark.test65apps.Navigation.Router

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
        var retrofitNetwork = RetrofitNetwork()
        var fragmentRouter = Router()
        var personDataBase: PersonDataBase? = null
        var personRepository = PersonRepository

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        personDataBase = PersonDataBase.getInstance(context!!)
    }

}
