package com.example.movie.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movie.DataSource.MovieDataFactory
import com.example.movie.Model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MovieViewModel :  ViewModel(){

   // var exucutor : Executor
    var moviedataModel : LiveData<PagedList<ResultsItem>>

    init {

     //   exucutor = Executors.newFixedThreadPool(5)

        var movieFactory = MovieDataFactory()

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        moviedataModel = LivePagedListBuilder(movieFactory,pageListConfig)
          //  .setFetchExecutor(exucutor)
            .build()
    }

    fun getData(): LiveData<PagedList<ResultsItem>>{
        return moviedataModel
    }
}