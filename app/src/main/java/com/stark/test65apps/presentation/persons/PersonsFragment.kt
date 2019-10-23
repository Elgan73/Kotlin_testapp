package com.stark.test65apps.presentation.persons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.stark.test65apps.R

class PersonsFragment: MvpAppCompatFragment(), PersonsView {
    companion object {
        const val TAG = "PersonFragment"

        lateinit var recView: RecyclerView
        val personAdapter = PersonAdapter()
        fun newInstance():PersonsFragment {
            val fragment: PersonsFragment = PersonsFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPersonsFragment: PersonsFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("Logs", "PersonFragment")
        return inflater.inflate(R.layout.person_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        person_swipeToRefresh.setOnRefreshListener {
//            mPersonsFragment.getData(resources.getStringArray()[spinnerPosition])
//        }
    }

    override fun setAdapterData(data: List<PersonItem>) {

    }
}