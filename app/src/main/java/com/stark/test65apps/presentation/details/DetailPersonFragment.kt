package com.stark.test65apps.presentation.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.squareup.picasso.Picasso
import com.stark.test65apps.AppsConstants
import com.stark.test65apps.R
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.android.synthetic.main.fragment_detail_person.*

class DetailPersonFragment : MvpAppCompatFragment(), DetailPersonView {
    companion object {
        const val TAG = "DetailsFragment"
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
        Log.d("Loooooogs", "Details Fragment")
        if (arguments != null) {
            val _id = arguments?.getInt(AppsConstants.DETAILS_BUNDLE_KEY_ID)
            mDetailPersonPresenter.loadPersonById(_id!!)
            Log.d("ArgsLogs", "Arguments: $arguments")
        } else {
            Log.d("ArgsLogs", "Arguments: $arguments")
        }
    }

    override fun setData(data: PersonItem) {
        detail_name.text = mDetailPersonPresenter.stringName(data.f_name)
        detail_surname.text = mDetailPersonPresenter.stringName(data.l_name)
        if (data.birthday.isNullOrBlank()) {
            detail_birthday.text = "-"
            detail_age.text = "-"
        } else {
            val persDate = data.birthday
            val patternDate = Regex(pattern = """\d{4}-\d{2}-\d{2}""")
            if (persDate!!.matches(patternDate)) {
                detail_birthday.text = mDetailPersonPresenter.parseReversDate(persDate)
                detail_age.text = mDetailPersonPresenter.age(mDetailPersonPresenter.parseReversDate(persDate))
            } else {
                detail_birthday.text = mDetailPersonPresenter.parseCorrectDate(persDate)
                detail_age.text = mDetailPersonPresenter.age(mDetailPersonPresenter.parseCorrectDate(persDate))
            }
        }
        if (data.avatr_url.isNullOrBlank()) {
            Picasso.get().load("https://sun9-48.userapi.com/c856020/v856020820/144058/JUFBqsiQlKw.jpg")
                .into(detail_avatar)
        } else {
            Picasso.get().load(data.avatr_url).into(detail_avatar)
        }
        detail_specialty.text = data.specialty_name

    }

}