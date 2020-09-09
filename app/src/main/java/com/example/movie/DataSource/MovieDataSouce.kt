package com.example.movie.DataSource

import androidx.paging.PageKeyedDataSource
import com.example.movie.Model.ResultsItem
import com.example.movie.Network.MovieServices
import com.example.movie.Network.ResApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSouce : PageKeyedDataSource<Long,ResultsItem>() {

    var api : MovieServices

    init {

        api = ResApi.restApi()
    }


    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {
       api.getMovie("b64d761def5c00e40e6a36e0032741bf","en-US",1,params.requestedLoadSize)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
                   t ->


               t.results?.let { callback.onResult(it,null,2L) }

           },{})

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovie("b64d761def5c00e40e6a36e0032741bf","en-US",params.key,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.results?.let { callback.onResult(it,params.key +1) }

            },{})

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }
}