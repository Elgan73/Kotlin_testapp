package com.stark.test65apps.presentation.spec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.stark.test65apps.R

class SpecAdapter(private val itemClickListener: (Int) -> Unit) : RecyclerView.Adapter<SpecAdapter.SpecViewHolder>() {

    private val personList = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecViewHolder {
        return SpecViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_spec, parent, false)){
            itemClickListener.invoke(it)
        }
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: SpecViewHolder, position: Int) {

        val item = personList[position]
        holder.bind(item)
    }

    fun setData(items: List<Int>) {
        personList.clear()
        personList.addAll(items)
        notifyDataSetChanged()
    }

    inner class SpecViewHolder(view: View, private val itemClickListener: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

        private val titleSpec = view.findViewById<Button>(R.id.specButton)

        fun bind(item: Int){
            if (item == 101) {
                titleSpec.text = "Менеджер"
            } else {
                titleSpec.text = "Разработчик"
            }
            titleSpec.setOnClickListener { itemClickListener.invoke(item) }
        }
    }
}