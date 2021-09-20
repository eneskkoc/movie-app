package com.example.movie.di

import android.app.Application
import com.example.movie.MovieApp
import com.example.movie.data.service.ApiService
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [ AndroidSupportInjectionModule::class,
        Bindings::class,
        ApiService::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<MovieApp> {
    fun inject(application: Application)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: Application): Builder
        fun build(): AppComponent
    }
}