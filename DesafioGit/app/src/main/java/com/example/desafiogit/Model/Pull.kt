package com.example.desafiogit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pull {
    @SerializedName("title")
    @Expose
    var name: String = ""
    @SerializedName("body")
    @Expose
    var description: String = ""
    @SerializedName("html_url")
    @Expose
    var url: String = ""
    @SerializedName("user")
    @Expose
    var user: User? = null

}