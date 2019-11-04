package com.stark.test65apps.presentation

import androidx.fragment.app.FragmentManager
import com.arellomobile.mvp.MvpPresenter
import com.stark.test65apps.App
import com.stark.test65apps.Navigation.Screens

class MainPresenter : MvpPresenter<MainView>() {

    fun onStart(supportFragmentManager: FragmentManager, fragment_container: Int, finishActivity: () -> Unit) {
        App.fragmentRouter.initRouter(supportFragmentManager, fragment_container, finishActivity)
        App.fragmentRouter.replace(Screens.FRAGMENTS.SPEC_FRAGMENT)
    }
}