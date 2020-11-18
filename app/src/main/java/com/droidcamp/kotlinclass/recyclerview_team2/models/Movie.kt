package com.droidcamp.kotlinclass.recyclerview_team2.models

import com.google.gson.annotations.SerializedName



data class Movie(


    @SerializedName("image")
    var imageUrl: String? = null,

    @SerializedName("rating")
    var movieRating: Double? = null,

    @SerializedName("title")
    var movieTitle: String? = null

//    val image: String,
//    val title: String,
//    val rating: Double
)


