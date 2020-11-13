package com.sourabhcodes.android.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sourabhcodes.android.mvvmnewsapp.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticle(article: Article): Long

    @Query("Select * from articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}