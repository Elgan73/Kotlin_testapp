package com.stark.test65apps.presentation.spec

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stark.test65apps.Domain.Dataclasess.Person
import com.stark.test65apps.Domain.Dataclasess.Response
import com.stark.test65apps.Domain.Dataclasess.Specialty
import com.stark.test65apps.R
import com.stark.test65apps.presentation.persons.PersonItem
import kotlinx.android.synthetic.main.item_spec.view.*

class SpecAdapter : RecyclerView.Adapter<SpecAdapter.SpecViewHolder>() {

    private var personList: List<PersonItem> = emptyList()
    private var person: List<Person> = emptyList()
    private var itemClickListener: ((PersonItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecViewHolder {
        return SpecViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_spec, parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: SpecViewHolder, position: Int) {

            Log.d("!!!!!!!!", "${personList[position].specialty_id}")
            holder.titleSpec.text = personList[0].specialty_name
    }

    fun setData(personList: List<PersonItem>) {
        this.personList = personList
        notifyDataSetChanged()
    }

    fun setItemsClickListener(itemClickListener: ((PersonItem) -> Unit)?) {
        this.itemClickListener = itemClickListener
    }

    inner class SpecViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = view.item_spec
        val titleSpec = view.specButton


        init {
            item.setOnClickListener {
                itemClickListener?.invoke(personList[adapterPosition])
            }
        }
    }
}