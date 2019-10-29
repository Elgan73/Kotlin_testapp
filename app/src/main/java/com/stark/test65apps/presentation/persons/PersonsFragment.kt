package com.stark.test65apps.presentation.persons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.R
import kotlinx.android.synthetic.main.person_fragment.*

class PersonsFragment: MvpAppCompatFragment(), PersonsView {
    companion object {
        const val TAG = "PersonFragment"
        val specId = 0
        val personAdapter = PersonAdapter()
        fun newInstance():PersonsFragment {
            val fragment = PersonsFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPersonsPresenter: PersonsPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("Logs", "PersonFragment")
        return inflater.inflate(R.layout.person_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            recViewPerson.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = personAdapter
            }

            personAdapter.setItemClickListener { personItem ->
                mPersonsPresenter.onItemClick(personItem)
            }
//        specId = arguments!!.getInt(AppsConstants.DETAILS_BUNDLE_KEY_ID)
        mPersonsPresenter.getData()
        mPersonsPresenter.getPerSpecData(specId)

    }



    override fun setAdapterData(data: List<PersonItem>) {
        personAdapter.setData(data)
    }

    override fun onResume() {
        super.onResume()
        mPersonsPresenter.getData()
//        mPersonsPresenter.getPerSpecData(data[position].specialty_id)
    }


}