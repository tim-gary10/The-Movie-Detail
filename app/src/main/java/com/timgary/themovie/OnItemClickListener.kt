package com.timgary.themovie

import com.timgary.themovie.network.MovieService
import java.text.FieldPosition

interface OnItemClickListener {
    fun onItemClick(item: MovieService, position: Int)
}