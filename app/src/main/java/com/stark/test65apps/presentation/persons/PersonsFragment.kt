package com.stark.test65apps.presentation.persons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.R
import kotlinx.android.synthetic.main.person_fragment.*

class PersonsFragment : MvpAppCompatFragment(), PersonsView, AdapterView.OnItemSelectedListener {

    private val mPersonAdapter = PersonAdapter()
    companion object {
        const val TAG = "PersonFragment"
        val personAdapter = PersonAdapter()
        fun newInstance(bundle: Bundle?): PersonsFragment {
            val fragment = PersonsFragment()
            val args: Bundle = bundle ?: Bundle()
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

        if (arguments!!.isEmpty) {
            Log.d("ArgsLogs", "$arguments")
            mPersonsPresenter.getData()
        } else {
            val id = arguments?.getInt(AppsConstants.PERSON_BY_SPEC)
            mPersonsPresenter.getPerSpecData(id!!)
        }
    }

    override fun setAdapterData(data: List<PersonItem>) {

        personAdapter.setData(data)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
}
