package com.timgary.themovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timgary.themovie.network.MovieService
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies : List<MovieService>, var clickListener: OnItemClickListener):
        RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

//        fun bindMovie(movie : MovieService){
//
//            itemView.movie_title.text = movie.title
//            itemView.movie_release_date.text = movie.release
//            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
//
//        }


        fun initialize(item: MovieService, action: OnItemClickListener){

            itemView.movie_title.text = item.title
            itemView.movie_release_date.text = item.release

            Glide.with(itemView).load(IMAGE_BASE + item.poster).into(itemView.movie_poster)

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.bindMovie(movies.get(position))

        holder.initialize(movies.get(position), clickListener)
    }

    override fun getItemCount(): Int = movies.size
}