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
import java.util.*
import kotlin.collections.HashSet

class SpecAdapter : RecyclerView.Adapter<SpecAdapter.SpecViewHolder>() {

    private var personList: List<PersonItem> = emptyList()
    private var itemClickListener: ((PersonItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecViewHolder {
        return SpecViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_spec, parent, false))
    }

    override fun getItemCount(): Int {
        val foundString = mutableListOf<String>()
        val duplicates = mutableListOf<String>()
        for (i in personList) {
            if (foundString.contains(i.specialty_name)) {
                duplicates.add(i.specialty_name)
            } else {
                foundString.add(i.specialty_name)
            }
        }
        return foundString.size
    }

    override fun onBindViewHolder(holder: SpecViewHolder, position: Int) {

            val foundString = mutableListOf<String>()
            val duplicates = mutableListOf<String>()
            for (i in personList) {
                if (foundString.contains(i.specialty_name)) {
                    duplicates.add(i.specialty_name)
                } else {
                    foundString.add(i.specialty_name)
                }
            }
            Log.d("LogsDupl", "vot: $foundString")
            holder.titleSpec.text = foundString[position]
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
            titleSpec.setOnClickListener {
                itemClickListener?.invoke(personList[adapterPosition])
            }
        }
    }
}