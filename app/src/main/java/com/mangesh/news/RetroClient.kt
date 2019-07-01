package com.mangesh.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroClient {

    companion object {
        var BASE_URL:String="https://api.nytimes.com/"
        var retrofit: Retrofit?=null

        fun getClient(): Api? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(Api::class.java)
        }
    }
}