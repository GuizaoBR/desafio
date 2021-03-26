package br.com.jeferson.git.challenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("total_count")
    @Expose
    val totalCount: Int? = null,
    @SerializedName("incomplete_results")
    @Expose
    val incompleteResults: Boolean? = null,
    @SerializedName("items")
    @Expose
    val items: List<T>? = null
)