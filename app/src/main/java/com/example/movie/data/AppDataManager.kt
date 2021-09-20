package com.example.movie.data

import com.example.movie.data.model.Movie
import com.example.movie.data.service.Api
import com.example.movie.di.PerApplication
import io.reactivex.Observable
import javax.inject.Inject

@PerApplication
class AppDataManager @Inject constructor(private val mApi: Api) {
    fun api() :Observable<Movie>{
        return mApi.getMovie()
    }
}