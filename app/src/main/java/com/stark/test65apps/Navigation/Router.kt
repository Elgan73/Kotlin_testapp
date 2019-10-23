package com.stark.test65apps.Navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Router {
    private lateinit var fragmentManager: FragmentManager
    private var containerId: Int = 0
    private lateinit var finishActivity: () -> Unit

    fun initRouter(fragmentManager: FragmentManager, containerId: Int, finishActivity: () -> Unit) {
        this.fragmentManager = fragmentManager
        this.containerId = containerId
        this.finishActivity = finishActivity
    }

    fun navigateTo(fragment: Screens.FRAGMENTS, bundle: Bundle? = null) {
        fragmentManager.beginTransaction()
            .add(containerId, Screens.createFragment(fragment, bundle))
            .addToBackStack(null)
            .commit()
    }

    fun replace(fragment: Screens.FRAGMENTS, bundle: Bundle? = null) {
        fragmentManager.beginTransaction()
            .replace(containerId, Screens.createFragment(fragment, bundle))
            .commit()
    }

    fun back() {
        if(fragmentManager.backStackEntryCount == 1) {
            finishActivity.invoke()
        } else {
            fragmentManager.popBackStack()
        }
    }
}