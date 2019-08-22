package com.ahanafi.id.myfirstapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProgrammingLanguageAdapter(private val listProgrammingLanguage: ArrayList<ProgrammingLanguage>) : RecyclerView.Adapter<ListProgrammingLanguageAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var imgIcon: ImageView = itemView.findViewById(R.id.img_item_icon)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_row_programming_language, p0, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProgrammingLanguage.size
    }

    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
        val (name, description, icon) = listProgrammingLanguage[p1]

        Glide.with(p0.itemView.context).load(icon).apply(RequestOptions().override(60,60)).into(p0.imgIcon)
        p0.tvName.text = name
        p0.tvDescription.text = description
    }


}