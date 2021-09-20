package com.example.movie.data.model

data class Movie(
    //@SerializedName("@meta")val meta: Meta?,
    val data: Data?,
    val status: String?,
    val status_message: String?
)