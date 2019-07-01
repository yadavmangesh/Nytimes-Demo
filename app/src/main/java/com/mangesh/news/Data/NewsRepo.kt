package com.mangesh.news.Data

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.mangesh.news.Api
import com.mangesh.news.Pojo.News
import com.mangesh.news.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepo {

    private var api: Api?

    private var liveNewsList: MutableLiveData<News> = MutableLiveData()

    init {
        api= RetroClient.getClient()
    }

    fun getTopStories(api_Key:String): MutableLiveData<News> {

        api?.getTopStories(api_Key)?.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("NewsRepo","onFailure: "+t.message)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsList=response.body()
                 Log.d("","onResponse: "+newsList.toString())
                liveNewsList.value=newsList

            }

        })

        return liveNewsList
    }
}