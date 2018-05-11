package com.xuzhiguang.paging

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import paging.android.example.com.pagingsample.Cheese

/**
 * Created by Administrator on 2018/5/11.
 */
class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.cheese_item, parent, false)) {
    var cheese: Cheese? = null
    private val nameTextView = itemView.findViewById<TextView>(R.id.name)
    fun fill(itemData: Cheese?) {
        this.cheese = itemData
        nameTextView.text = cheese?.name
    }
}