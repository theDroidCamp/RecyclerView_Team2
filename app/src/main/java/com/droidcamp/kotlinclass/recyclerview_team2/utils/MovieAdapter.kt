package com.droidcamp.kotlinclass.recyclerview_team2.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.droidcamp.kotlinclass.recyclerview_team2.R
import com.droidcamp.kotlinclass.recyclerview_team2.models.Movie
import kotlinx.android.synthetic.main.layout_movie_list.view.*

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
         val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list, parent, false)
        return MovieHolder(view)

    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movieTitle = movies[position]
        holder.bind(movieTitle)



    }

    override fun getItemCount() : Int {
        return movies.size
    }

    class MovieHolder(itemView: View) : ViewHolder(itemView) {
        private var movie : Movie? = null

        fun bind(movie : Movie)  {
            this.movie = movie
            itemView.tvTitle.text = movie.movieTitle
            itemView.tvRating.text = movie.movieRating.toString()
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .centerCrop()
//                .centerInside()
                .placeholder(R.drawable.ic_baseline_star_rate_24)
                .into(itemView.imageView)


        }




//

    }

}