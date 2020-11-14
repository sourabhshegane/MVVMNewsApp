package com.sourabhcodes.android.mvvmnewsapp.repository

import com.sourabhcodes.android.mvvmnewsapp.api.RetrofitInstance
import com.sourabhcodes.android.mvvmnewsapp.db.ArticleDatabase
import com.sourabhcodes.android.mvvmnewsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) = RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsertArticle(article: Article) = db.getArticleDAO().upsertArticle(article)

    fun getSavedNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)

}