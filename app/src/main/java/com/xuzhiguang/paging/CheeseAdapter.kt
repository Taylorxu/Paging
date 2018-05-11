package com.xuzhiguang.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import paging.android.example.com.pagingsample.Cheese

/**
 * Created by Administrator on 2018/5/11.
 */
class CheeseAdapter : PagedListAdapter<Cheese, ItemViewHolder>(diffCallBack) {
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.fill(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(parent)


    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallBack= object : DiffUtil.ItemCallback<Cheese>() {
            override fun areItemsTheSame(oldItem: Cheese?, newItem: Cheese?): Boolean =oldItem?.id==newItem?.id

            override fun areContentsTheSame(oldItem: Cheese?, newItem: Cheese?): Boolean =oldItem==newItem

        }
    }
}