package com.example.movie

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.movie.Adapter.AdapterMovie
import com.example.movie.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var viewModel: MovieViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        //   viewModel?.getData()
        viewModel?.moviedataModel?.observe(this, Observer {
            val adapter = AdapterMovie()
            adapter.submitList(it)
            recylerView.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                recylerView.adapter = adapter
            }


        })


    }

}