package com.example.desafiogit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repository {

    @SerializedName("name")
    @Expose
    var name: String = ""
    @SerializedName("description")
    @Expose
    var description : String = ""
    @SerializedName("owner")
    @Expose
    var user: User? = null
    @SerializedName("forks_count")
    @Expose
    var numberFork: String = "0"
    @SerializedName("stargazers_count")
    @Expose
    var numberStars: String = "0"



}