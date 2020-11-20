package com.example.desafiogit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiogit.API.RepositoryData
import com.example.desafiogit.Model.ListPull

class PullViewModel(private val user: String, private val repo: String) : ViewModel() {
    private var listPull : MutableLiveData<ListPull?>? = null

     fun init() {
        fillPull()
    }

    private fun fillPull() {
        if (listPull != null) return
        listPull = RepositoryData.getPull(user, repo)



    }

    fun getPull() : LiveData<ListPull?> {
        return  listPull!!
    }

}