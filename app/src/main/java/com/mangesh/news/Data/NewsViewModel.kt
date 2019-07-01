package com.mangesh.news.Data

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.mangesh.news.Data.NewsRepo
import com.mangesh.news.Pojo.News

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    var liveNewsList:MutableLiveData<News> = MutableLiveData()

    private val newsRepo: NewsRepo = NewsRepo()


    fun getList(api_Key:String){
    liveNewsList=newsRepo.getTopStories(api_Key)

    }
}