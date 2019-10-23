package com.stark.test65apps.presentation.persons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stark.test65apps.R
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private val personList : List<PersonItem> = emptyList()
    private val itemClickListener: ((PersonItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonAdapter.PersonViewHolder, position: Int) {
        holder.namePerson.text = personList[position].f_name
        holder.surnamePerson.text = personList[position].l_name
        holder.bdayPerson.text = personList[position].birthday
        Picasso.get().load(personList[position].avatr_url).into(holder.avatarPerson)
        holder.specPerson.text = personList[position].specialty_name
    }

    inner class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view.person_item
        val namePerson = view.name_person
        val surnamePerson = view.last_name_person
        val bdayPerson = view.bday_person
        val avatarPerson = view.avatar
        val specPerson = view.spec_person

        init {
            item.setOnClickListener {
                itemClickListener?.invoke(personList[adapterPosition])
            }
        }
    }
}