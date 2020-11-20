package com.example.desafiogit.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiogit.API.RepositoryData
import com.example.desafiogit.Model.ListRepository

class MainViewModel() : ViewModel(){
    private var listRepo : MutableLiveData<ListRepository?>? = null

    fun init() {
        fillRepo()
    }

    private fun fillRepo() {
        if (listRepo != null) return
        listRepo = RepositoryData.getRepo()


    }

    fun getListRepo() : LiveData<ListRepository?>{
        return  listRepo!!
    }

}