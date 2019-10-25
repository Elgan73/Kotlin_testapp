package com.stark.test65apps.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.squareup.picasso.Picasso
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.presentation.persons.PersonItem
import com.stark.test65apps.R
import kotlinx.android.synthetic.main.fragment_detail_person.*
import java.util.*

class DetailPersonFragment : MvpAppCompatFragment(), DetailPersonView {


    companion object {
        const val TAG = "DetailsFragment"
        var status = false
        var _id = ""
        fun newInstance(bundle: Bundle?): DetailPersonFragment {
            val fragment = DetailPersonFragment()
            val args: Bundle = bundle ?: Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mDetailPersonPresenter: DetailPersonPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _id = arguments?.getString(AppsConstants.DETAILS_BUNDLE_KEY_ID).orEmpty()
        mDetailPersonPresenter.loadPersonById(id)

    }

    override fun setData(data: PersonItem) {
//        val date : Date? = null
        Picasso.get().load(data.avatr_url).into(detail_avatar)
        detail_name.text = data.f_name
        detail_surname.text = data.l_name
        detail_birthday.text = data.birthday
        detail_age.text = data.birthday
        detail_specialty.text = data.specialty_name

    }

}