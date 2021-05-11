package com.example.tmobileapp.repo

import android.content.Context
import com.example.tmobileapp.repo.local.PageRoomDatabase
import com.example.tmobileapp.repo.remote.RetrofitInstance
import com.example.tmobileapp.util.PageState
import com.example.tmobileapp.util.isConnected
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class PageRepo private constructor(context: Context) {
    private val pageService by lazy { RetrofitInstance.pageService }
    private val pageDao by lazy { PageRoomDatabase.getDatabase(context).pageDao() }

    val page = flow {
        // Change state to loading
        emit(PageState.Loading)

        // This logic handles updating data from server if we have internet connection
        val state = if (context.isConnected) {
            try {
                // Load page from server and update db if not null
                val page = pageService.getPage().page?.also { pageDao.insert(it) }
                // if page == null return PageState.None else return null
                page.let { if (it == null) PageState.None else null }
            } catch (ex: Exception) {
                // update error state if we end up here
                PageState.Error("Something went wrong fetching data.")
            }
        } else null

        val pageFromDb = pageDao.getPage().map {
            // db has 2 states PageState.Loaded if we have data or PageState.None when empty
            if (it.isNotEmpty()) PageState.Loaded(it) else state ?: PageState.None
        }
        // Load current data in DB
        emitAll(pageFromDb)
    }

    companion object {
        // Singleton prevents multiple instances of PageRepo opening at the
        // same time.
        @Volatile
        private var INSTANCE: PageRepo? = null

        fun getRepo(context: Context) = INSTANCE ?: synchronized(this) {
            PageRepo(context).also { INSTANCE = it }
        }
    }
}