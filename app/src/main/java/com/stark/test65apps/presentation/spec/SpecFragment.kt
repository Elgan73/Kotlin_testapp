package com.stark.test65apps.presentation.spec

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.stark.test65apps.Data.Db.Entity.PersonEntity
import com.stark.test65apps.R
import com.stark.test65apps.presentation.persons.PersonItem
import com.stark.test65apps.presentation.persons.PersonsFragment
import kotlinx.android.synthetic.main.fragment_spec.*
import kotlinx.android.synthetic.main.fragment_spec.view.*

class SpecFragment: MvpAppCompatFragment(), SpecView, AdapterView.OnItemSelectedListener {


    companion object {
        const val TAG = "SpecialtyFragment"
        lateinit var recView: RecyclerView
        val specAdapter = SpecAdapter()

        fun newInstance(): SpecFragment {
            val fragment = SpecFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mSpecPresenter: SpecPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("Logs", "SpecialtyFragment")
        return inflater.inflate(R.layout.fragment_spec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        specAdapter.setItemsClickListener { PersonItem ->
            mSpecPresenter.onItemClick(PersonItem)
        }
        recView = view.specRecView
        recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = specAdapter
        }
        mSpecPresenter.getData()
    }

    override fun setAdapterData(data: List<PersonItem>) {
        specAdapter.setData(data)
    }

    override fun showMessage(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("!!!!!!!!!", "isPressed")
        mSpecPresenter.getData()

    }

}