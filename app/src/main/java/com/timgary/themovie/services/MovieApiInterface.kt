package com.timgary.themovie.services

import com.timgary.themovie.network.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=d6851de58d87458616c9154f580fe85f")
    fun getMovieList(): Call<MovieResponse>
}