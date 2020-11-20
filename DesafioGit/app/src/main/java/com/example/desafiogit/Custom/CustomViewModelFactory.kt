package com.example.desafiogit.Custom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogit.PullViewModel

class CustomViewModelFactory(private val user: String, private val  repo: String): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullViewModel(user, repo) as T
    }

}