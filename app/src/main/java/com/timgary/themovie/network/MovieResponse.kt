package com.timgary.themovie.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies: List<MovieService>
):Parcelable{
    constructor() : this(mutableListOf())
}