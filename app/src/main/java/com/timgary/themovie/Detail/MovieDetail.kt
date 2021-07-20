package com.timgary.themovie.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.timgary.themovie.R
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movie_item.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieDetail : AppCompatActivity() {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private val MOVIE_TITLE = "M_TITLE"
    private val MOVIE_RELEASE_DATE = "M_R_DATE"
    private val MOVIE_POSTER = "M_POSTER"
    private val MOVIE_RATE = "M_RATE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val extras = intent.extras

        if (extras != null) {
            populateDetails(extras)
        } else {
            finish()
        }

    }
    private fun populateDetails(extras: Bundle) {

        extras.getString(MOVIE_POSTER)?.let { posterPath ->
            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500/$posterPath")
                    .transform(CenterCrop())
                    .into(img_detail)
        }

        title_detail.text = extras.getString(MOVIE_TITLE, "")
        release_date_detail.text = extras.getString(MOVIE_RELEASE_DATE, "")
//        rate_detail.rating = extras.getFloat(MOVIE_RATE, 0f) / 2


    }
}