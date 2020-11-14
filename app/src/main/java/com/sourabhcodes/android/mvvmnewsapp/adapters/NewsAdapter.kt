package com.sourabhcodes.android.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.sourabhcodes.android.mvvmnewsapp.R
import com.sourabhcodes.android.mvvmnewsapp.models.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter(
    private val articleClicked: OnArticleClicked
): RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article_preview,
                parent,
                false
                )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(currentArticle.urlToImage).into(ivArticleImage)
            tvSource.text = currentArticle.source.name
            tvTitle.text = currentArticle.title
            tvDescription.text = currentArticle.description
            tvPublishedAt.text = currentArticle.publishedAt
            holder.itemView.setOnClickListener{
                articleClicked.onArticleClicked(currentArticle)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    private val differCallBack = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listner: (Article) -> Unit){
        onItemClickListener = listner
    }

    interface OnArticleClicked{
        fun onArticleClicked(article: Article)
    }
}