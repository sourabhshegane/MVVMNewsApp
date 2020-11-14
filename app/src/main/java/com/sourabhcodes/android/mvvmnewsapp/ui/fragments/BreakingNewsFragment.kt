package com.sourabhcodes.android.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sourabhcodes.android.mvvmnewsapp.R
import com.sourabhcodes.android.mvvmnewsapp.ui.NewsActivity
import com.sourabhcodes.android.mvvmnewsapp.ui.NewsViewModel

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}