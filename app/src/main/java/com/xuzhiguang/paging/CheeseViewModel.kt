package com.xuzhiguang.paging

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import paging.android.example.com.pagingsample.Cheese
import paging.android.example.com.pagingsample.CheeseDb
import paging.android.example.com.pagingsample.ioThread

/**
 * Created by Administrator on 2018/5/11.
 */
class CheeseViewModel(app:Application): AndroidViewModel(app) {
    private val dao = CheeseDb.get(app).cheeseDao()
    companion object {
        private const val PAGE_SIZE = 30
        private const val ENABLE_PLACEHOLDERS = true
    }

    /**
     * 获取数据 room或者 网络请求 耗时操作
     */
    val allCheeses = LivePagedListBuilder(dao.allCheesesByName(), PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
            .build()).build()

    fun insert(text: CharSequence) = ioThread {
        dao.insert(Cheese(id = 0, name = text.toString()))
    }

    fun remove(cheese: Cheese) = ioThread {
        dao.delete(cheese)
    }
}