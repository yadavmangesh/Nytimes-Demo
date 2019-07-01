package com.mangesh.news

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mangesh.news.Pojo.News
import com.mangesh.news.Pojo.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_row.view.*
import java.lang.Exception

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private var newsList:List<Result> = mutableListOf()


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.news_row,p0,false))
    }

    override fun getItemCount(): Int {
       return  newsList.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val news=newsList[p1]
        var url:String?=null
        try {
            if (news.multimedia?.size!=0){
                url=news.multimedia?.get(1)?.url
            }
            Picasso.get().load(url).placeholder(R.drawable.ic_image_black_24dp)
                .into(p0.itemView.ivNews)
            p0.itemView.tvNews.text= news._abstract
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    fun setData(list:News){
        try {
            newsList= list.results!!
            notifyDataSetChanged()
        }catch (e:Exception){

        }

    }

}