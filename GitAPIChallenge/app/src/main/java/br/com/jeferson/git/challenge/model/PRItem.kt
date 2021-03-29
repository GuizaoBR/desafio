package br.com.jeferson.git.challenge.model

import com.google.gson.annotations.SerializedName

data class PRItem(
    val url: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
    @SerializedName("html_url")
    val htmlPage: String? = null,
    val user: User
)




