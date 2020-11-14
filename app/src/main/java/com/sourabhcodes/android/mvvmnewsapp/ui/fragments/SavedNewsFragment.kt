package com.sourabhcodes.android.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourabhcodes.android.mvvmnewsapp.R
import com.sourabhcodes.android.mvvmnewsapp.adapters.NewsAdapter
import com.sourabhcodes.android.mvvmnewsapp.models.Article
import com.sourabhcodes.android.mvvmnewsapp.ui.NewsActivity
import com.sourabhcodes.android.mvvmnewsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_saved_news.*

class SavedNewsFragment: Fragment(R.layout.fragment_saved_news), NewsAdapter.OnArticleClicked {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "BreakingNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        initRecyclerView()

        /*viewModel.breakingNews.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message ?.let {
                        Log.e(TAG, it)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })*/
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun initRecyclerView(){
        newsAdapter = NewsAdapter(this)
        rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onArticleClicked(article: Article) {
        val bundle = Bundle().apply {
            putSerializable("article", article)
        }
        findNavController().navigate(R.id.action_savedNewsFragment_to_articleFragment, bundle)
    }
}