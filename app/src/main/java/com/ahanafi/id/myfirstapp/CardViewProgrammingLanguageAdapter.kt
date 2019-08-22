package com.ahanafi.id.myfirstapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewProgrammingLanguageAdapter(private val listProgrammingLanguage : ArrayList<ProgrammingLanguage>) : RecyclerView.Adapter<CardViewProgrammingLanguageAdapter.CardViewViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ProgrammingLanguage)
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView = itemView.findViewById(R.id.img_item_icon)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)
        var btnDetail : Button = itemView.findViewById(R.id.button_show_detail)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_cardview_programming_language, p0, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProgrammingLanguage.size
    }

    override fun onBindViewHolder(p0: CardViewViewHolder, p1: Int) {
        val (name, description, icon) = listProgrammingLanguage[p1]

        Glide.with(p0.itemView.context).load(icon).apply(RequestOptions().override(60,60)).into(p0.imgIcon)

        p0.tvName.text = name
        p0.tvDescription.text = description

        p0.btnDetail.setOnClickListener {
            onItemClickCallback.onItemClicked(listProgrammingLanguage[p0.adapterPosition])
        }

    }

}
