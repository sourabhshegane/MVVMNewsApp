package com.sourabhcodes.android.mvvmnewsapp.repository

import com.sourabhcodes.android.mvvmnewsapp.api.RetrofitInstance
import com.sourabhcodes.android.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}