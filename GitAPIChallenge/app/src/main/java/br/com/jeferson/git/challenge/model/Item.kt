package br.com.jeferson.git.challenge.model

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null,
    @SerializedName("forks_count")
    val forksCount: Int? = null,
    val owner: Owner
)
