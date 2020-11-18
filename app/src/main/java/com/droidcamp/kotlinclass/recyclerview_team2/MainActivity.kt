package com.droidcamp.kotlinclass.recyclerview_team2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droidcamp.kotlinclass.recyclerview_team2.databinding.ActivityMainBinding
import com.droidcamp.kotlinclass.recyclerview_team2.models.Movie
import com.droidcamp.kotlinclass.recyclerview_team2.network.ApiService
import com.droidcamp.kotlinclass.recyclerview_team2.utils.MovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter : MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)




        ApiService().getMovie().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val movies = response.body()
                movies?.let {
                    displayMovies(it)
                }

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }

        })


    }

    private fun displayMovies(movies: List<Movie>) {
        mRecyclerView = binding.recyclerview
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = MovieAdapter(movies)
        mRecyclerView.adapter = mAdapter

    }
}