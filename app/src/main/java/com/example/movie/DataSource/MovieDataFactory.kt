package com.example.movie.DataSource

import androidx.lifecycle.MutableLiveData
import com.example.movie.Model.ResultsItem
import javax.sql.DataSource

class MovieDataFactory : androidx.paging.DataSource.Factory<Long, ResultsItem>() {


    var mutableLivedata: MutableLiveData<MovieDataSouce>
    var movieDataSouce: MovieDataSouce

    init {
        mutableLivedata = MutableLiveData()
        movieDataSouce = MovieDataSouce()
    }

    override fun create(): androidx.paging.DataSource<Long, ResultsItem> {
        mutableLivedata.postValue(movieDataSouce)
        return movieDataSouce

    }

    fun getMutableLiveData(): MutableLiveData<MovieDataSouce> {
        return mutableLivedata
    }
}