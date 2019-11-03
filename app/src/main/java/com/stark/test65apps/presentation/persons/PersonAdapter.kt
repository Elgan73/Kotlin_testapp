package com.stark.test65apps.presentation.persons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stark.test65apps.R
import kotlinx.android.synthetic.main.person_item.view.*


class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var personList: MutableList<PersonItem> = mutableListOf()
    private var itemClickListener: ((PersonItem) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.namePerson.text = PersonsPresenter().stringName(personList[position].f_name)
        holder.surnamePerson.text = PersonsPresenter().stringName(personList[position].l_name)

        if (personList[position].birthday.isNullOrBlank()) {
            holder.bdayPerson.text = "-"
        } else {
            val personDate = personList[position].birthday
            val patternDate = Regex(pattern = """\d{4}-\d{2}-\d{2}""")
            if (personDate!!.matches(patternDate)) {
                holder.bdayPerson.text = PersonsPresenter().age(PersonsPresenter().parseReversDate(personDate))
            } else {
                holder.bdayPerson.text = PersonsPresenter().age(PersonsPresenter().parseCorrectDate(personDate))
            }
        }

        if (personList[position].avatr_url.isNullOrBlank()) {
            Picasso
                .get()
                .load("https://sun9-48.userapi.com/c856020/v856020820/144058/JUFBqsiQlKw.jpg")
                .into(holder.avatarPerson)
        } else {
            Picasso.get().load(personList[position].avatr_url).into(holder.avatarPerson)
        }
        holder.specPerson.text = personList[position].specialty_name
    }

    fun setData(personList: List<PersonItem>) {
        this.personList = personList as MutableList<PersonItem>
        notifyDataSetChanged()
    }

    fun setItemClickListener(itemClickListener: ((PersonItem) -> Unit)?) {
        this.itemClickListener = itemClickListener
    }

    inner class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view.person_item
        val namePerson = view.name_person
        val surnamePerson = view.last_name_person
        val bdayPerson = view.age_person
        val avatarPerson = view.avatar
        val specPerson = view.spec_person

        init {
            item.setOnClickListener {
                itemClickListener?.invoke(personList[adapterPosition])
            }
        }
    }
}


