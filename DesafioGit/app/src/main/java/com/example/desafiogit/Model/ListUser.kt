package com.example.desafiogit.Model

import com.google.gson.annotations.SerializedName

class ListUser {
    @SerializedName("items")
    var listUser: List<User>? = null
}