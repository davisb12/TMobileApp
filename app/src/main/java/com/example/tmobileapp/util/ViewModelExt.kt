package com.example.tmobileapp.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Extension function for ViewModels with constructor params
@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> Fragment.viewModelFactory(crossinline creator: () -> VM): Lazy<VM> {
    return viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return creator() as T
            }
        }
    }
}