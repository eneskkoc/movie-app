package com.example.movie

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.example.movie.di.DaggerAppComponent

class MovieApp: DaggerApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun applicationInjector(): AndroidInjector<out MovieApp> {
        return DaggerAppComponent.builder().app(this).build()
    }
}
