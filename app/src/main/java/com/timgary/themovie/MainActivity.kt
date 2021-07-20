package com.timgary.themovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.timgary.themovie.Detail.MovieDetail
import com.timgary.themovie.network.MovieResponse
import com.timgary.themovie.network.MovieService
import com.timgary.themovie.services.MovieApiInterface
import com.timgary.themovie.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<com.timgary.themovie.network.MovieService> ->
            rv_movies_list.adapter = MovieAdapter(movies, this)
        }


    }
    private fun getMovieData(callback: (List<com.timgary.themovie.network.MovieService>) -> Unit){

        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }



    override fun onItemClick(item : MovieService, position: Int) {
//        Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra("M_TITLE", item.title)
        intent.putExtra("M_R_DATE", item.release)
        intent.putExtra("M_POSTER", item.poster)
//        intent.putExtra("M_RATE", item.rating)
        startActivity(intent)
    }
}