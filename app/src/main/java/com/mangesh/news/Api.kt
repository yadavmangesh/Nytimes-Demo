package com.mangesh.news

import com.mangesh.news.Pojo.News
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("svc/topstories/v2/home.json")
    fun getTopStories(@Query("api-key") api_key:String):Call<News>
}