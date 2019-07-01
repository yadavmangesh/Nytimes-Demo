package com.mangesh.news

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.mangesh.news.Data.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val API_KEY:String="zchnS1BR51Dk7rJ2SW0pAaLh9Y4ejACw"

    private var newsAdapter:NewsAdapter= NewsAdapter()

    private lateinit var newsViewModel:NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel=ViewModelProviders.of(this).get(NewsViewModel::class.java)

        rvNews.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=newsAdapter
        }

        newsViewModel.getList(API_KEY)
        newsViewModel.liveNewsList.observe(this, Observer {

            list-> list?.let { newsAdapter.setData(it) }
        })


    }
}
