package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
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