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
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.android.synthetic.main.fragment_detail_person.*
import org.joda.time.LocalDate
import org.joda.time.Years
import java.text.SimpleDateFormat
import org.joda.time.format.DateTimeFormat

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
        return inflater.inflate(com.stark.test65apps.R.layout.fragment_detail_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Loooooogs", "Details Fragment")
        if (arguments != null) {
            val _id = arguments?.getInt(AppsConstants.DETAILS_BUNDLE_KEY_ID)
//            Log.d("Loooooogs", "Приходит ID: $_id")
            mDetailPersonPresenter.loadPersonById(_id!!)
        } else {
            Log.d("ArgsLogs", "Arguments: $arguments")
        }
    }

    override fun setData(data: PersonItem) {
        var nPers = data.f_name
        nPers = nPers.substring(0, 1).toUpperCase() + nPers.substring(1).toLowerCase()
        detail_name.text = nPers

        var sPers = data.l_name
        sPers = sPers.substring(0, 1).toUpperCase() + sPers.substring(1).toLowerCase()
        detail_surname.text = sPers

        if (data.birthday.isNullOrBlank()) {
            detail_birthday.text = "--"
            detail_age.text = "--"
        } else {
            val persDate = data.birthday
            val reversDate = SimpleDateFormat("yyyy-MM-dd")
            val correctDate = SimpleDateFormat("dd-MM-yyyy")
            val date = SimpleDateFormat("dd.MM.yyyy")
            val aaa = reversDate.parse(persDate)
            val aA = date.format(aaa)
            val bbb = correctDate.parse(persDate)
            val bB = date.format(bbb)
            val patternDate = Regex(pattern = """\d{4}-\d{2}-\d{2}""")
            if (persDate!!.matches(patternDate)) {
                detail_birthday.text = aA
                val formatter = DateTimeFormat.forPattern("dd.MM.yyyy")
                val past = formatter.parseLocalDate(aA)
                val now = LocalDate.now()
                val age = Years.yearsBetween(past, now)
                detail_age.text = age.years.toString()
            } else {
                detail_birthday.text = bB
                val formatter = DateTimeFormat.forPattern("dd.MM.yyyy")
                val past = formatter.parseLocalDate(bB)
                val now = LocalDate.now()
                val age = Years.yearsBetween(past, now)
                detail_age.text = age.years.toString()
            }
        }
        if (data.avatr_url.isNullOrBlank()) {
            Picasso.get().load("https://sun9-48.userapi.com/c856020/v856020820/144058/JUFBqsiQlKw.jpg").into(detail_avatar)
        } else {
            Picasso.get().load(data.avatr_url).into(detail_avatar)
        }
        detail_specialty.text = data.specialty_name

    }

}