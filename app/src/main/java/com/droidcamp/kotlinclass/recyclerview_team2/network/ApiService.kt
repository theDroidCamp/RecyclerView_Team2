package com.droidcamp.kotlinclass.recyclerview_team2.network

import com.droidcamp.kotlinclass.recyclerview_team2.models.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.simplifiedcoding.in/"
interface ApiService {

    @GET("course-apis/recyclerview/movies")
    fun getMovie(): Call<List<Movie>>

    companion object {
        operator fun invoke() : ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}