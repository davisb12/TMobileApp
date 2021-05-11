package com.example.tmobileapp.viewmodel


import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tmobileapp.repo.PageRepo
import com.example.tmobileapp.util.PageState

class PageViewModel(repo: PageRepo) : ViewModel() {

    // Transforming our page into List<Card> for view to observe
    // From LiveData<PageState<List<Page>>> into LiveData<PageState<List<CardHolder>>>
    val cards = Transformations.map(repo.page.asLiveData()) { state ->
        when (state) {
            is PageState.Loading -> PageState.Loading
            is PageState.Loaded -> state.data.firstOrNull().let { page ->
                if (page?.cards.isNullOrEmpty()) PageState.None else PageState.Loaded(page!!.cards!!)
            }
            is PageState.None -> PageState.None
            is PageState.Error -> PageState.Error(state.reason)
        }
    }

}