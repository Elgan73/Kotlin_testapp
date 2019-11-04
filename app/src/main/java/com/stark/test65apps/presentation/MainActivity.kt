package com.stark.test65apps.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stark.test65apps.App
import com.stark.test65apps.Navigation.Screens
import com.stark.test65apps.R

class MainActivity : MvpAppCompatActivity(), MainView {

    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_speciality -> {
                App.fragmentRouter.replace(Screens.FRAGMENTS.SPEC_FRAGMENT)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_person -> {
                App.fragmentRouter.replace(Screens.FRAGMENTS.PERSONS_FRAGMENT)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        mMainPresenter.onStart(supportFragmentManager, R.id.fragment_container, ::finishActivity)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }

    override fun onBackPressed() {
        App.fragmentRouter.back()
    }

    private fun finishActivity() {
        finish()
    }
}
