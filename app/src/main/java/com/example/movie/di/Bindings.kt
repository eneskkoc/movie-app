package com.example.movie.di

import com.example.movie.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Bindings {
    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}