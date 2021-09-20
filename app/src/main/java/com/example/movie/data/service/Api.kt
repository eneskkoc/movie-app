package com.example.movie.data.service

import com.example.movie.data.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("list_movies.json?sort_by=date_added")
    fun getMovie(
        //@Query("sort_by") sort_by: String,
    ): Observable<Movie>
}