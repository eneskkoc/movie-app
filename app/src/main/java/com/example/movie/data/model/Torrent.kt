package com.example.movie.data.model

data class Torrent(
    val date_uploaded: String?,
    val date_uploaded_unix: String?,
    val hash: String?,
    val peers: Int?,
    val quality: String?,
    val seeds: Int?,
    val size: String?,
    val size_bytes: String?,
    val type: String?,
    val url: String?
)