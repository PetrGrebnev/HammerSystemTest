package com.example.hammersystemtest.ui.home

import android.content.Context
import com.example.hammersystemtest.model.Repository
import com.example.hammersystemtest.utils.BaseViewModelFactory
import javax.inject.Inject

class HomeViewModelProvider @Inject constructor(
    private val repository: Repository,
    private val context: Context
): BaseViewModelFactory<HomeViewModel>(HomeViewModel::class.java) {
    override fun createViewModel(): HomeViewModel {
        return HomeViewModel(repository, context)
    }
}