package com.stark.test65apps.Navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.stark.test65apps.presentation.details.DetailPersonFragment
import com.stark.test65apps.presentation.persons.PersonsFragment
import com.stark.test65apps.presentation.spec.SpecFragment

object Screens {

    private val specFragment = SpecFragment()
    private val personsFragment = PersonsFragment()

    enum class FRAGMENTS(fragmentName: String) {
        SPEC_FRAGMENT("SPEC FRAGMENT"),
        PERSONS_FRAGMENT("PERSONS FRAGMENT"),
        DETAIL_FRAGMENT("DETAIL FRAGMENT")
    }

    fun createFragment(fragment: FRAGMENTS, bundle: Bundle? = null): Fragment = when (fragment) {
        Screens.FRAGMENTS.SPEC_FRAGMENT -> specFragment
        Screens.FRAGMENTS.PERSONS_FRAGMENT -> personsFragment
        Screens.FRAGMENTS.DETAIL_FRAGMENT -> DetailPersonFragment.newInstance(bundle)
    }
}