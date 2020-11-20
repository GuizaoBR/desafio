package com.example.desafiogit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("avatar_url")
    @Expose
    var avatar_url : String = ""
    @SerializedName("login")
    @Expose
    var login : String = ""

}