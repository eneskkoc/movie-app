package com.example.movie.ui.main

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.AppDataManager
import com.example.movie.data.model.Movy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private var appDataManager: AppDataManager) : ViewModel() {
    val movieData = MutableLiveData<State>()
    var mMovie: List<Movy?>? = null
    val progressVisible = ObservableField(false)

    @SuppressLint("CheckResult")
    fun movie() {
        progressVisible.set(true)
        appDataManager.api()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({movie -> //success
                mMovie= movie.data?.movies
                movieData.postValue(State.OnCompleted)
                progressVisible.set(false)
            },{
                movieData.value = State.OnError(it.message ?: "Bir hatayla karşılaşıldı")
            })
    }


    sealed class State {
        object OnCompleted : State()
        data class OnError(val error: String) : State()
    }
}