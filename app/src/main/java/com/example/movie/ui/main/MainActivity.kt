package com.example.movie.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.list_movie.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    lateinit var viewmodel: MainViewModel
    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        viewmodel = ViewModelProvider(this, viewModelProvider).get(MainViewModel::class.java)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.viewmodel = viewmodel
        binding?.moviesRecyclerView?.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        viewmodel.movie()
        viewmodel.movieData.observe(this, { state ->
            when (state) {
                is MainViewModel.State.OnCompleted -> onMovie()
                is MainViewModel.State.OnError -> onMessage(state.error)
            }
        })
    }

    private fun onMessage(error: String) {
        Log.e("backend hatası", error)
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun onMovie() {
        binding?.moviesRecyclerView?.adapter = MovieAdapter(viewmodel.mMovie!!.sortedByDescending { it?.year })
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatchingAndroidInjector
    }


}