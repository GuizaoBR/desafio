package br.com.jeferson.git.challenge.model

import com.google.gson.annotations.SerializedName

data class Owner(
    val login: String? = null,
    val id: Int? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null
)