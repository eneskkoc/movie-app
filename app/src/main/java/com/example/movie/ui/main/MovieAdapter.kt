package com.example.movie.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.model.Movy
import com.example.movie.databinding.ListMovieBinding

class MovieAdapter (private val movie: List<Movy?>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {


    override fun getItemCount() = movie.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieHolder(
            DataBindingUtil.inflate
                (
                LayoutInflater.from(parent.context),
                R.layout.list_movie,
                parent,
                false
            )
        )
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.movieBinding.movie= movie[position]
        //holder.recyclerviewForecastBinding.weather= forecast[position]?.weather?.get(position)

    }
    inner class MovieHolder(val movieBinding:ListMovieBinding) :
        RecyclerView.ViewHolder(movieBinding.root)

}