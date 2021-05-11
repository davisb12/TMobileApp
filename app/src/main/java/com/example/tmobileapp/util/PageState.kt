package com.example.tmobileapp.util

sealed class PageState<out R> {
    data class Loaded<T>(val data: T) : PageState<T>()
    data class Error(val reason: String) : PageState<Nothing>()
    object None : PageState<Nothing>()
    object Loading : PageState<Nothing>()
}