package com.sourabhcodes.android.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.sourabhcodes.android.mvvmnewsapp.repository.NewsRepository

class NewsViewModel(
    val repository: NewsRepository
): ViewModel() {
}