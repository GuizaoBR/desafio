package com.example.desafiogit.Model

import androidx.lifecycle.LiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListRepository {

    @SerializedName("items")
    @Expose
    var listRepository: List<Repository>? = null
}