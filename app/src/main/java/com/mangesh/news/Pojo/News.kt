package com.mangesh.news.Pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mangesh.news.Pojo.Multimedium

class News {
    @SerializedName("status")
    @Expose
     var status: String? = null
    @SerializedName("copyright")
    @Expose
     var copyright: String? = null
    @SerializedName("section")
    @Expose
     var section: String? = null
    @SerializedName("last_updated")
    @Expose
     var lastUpdated: String? = null
    @SerializedName("num_results")
    @Expose
     var numResults: Int? = null
    @SerializedName("results")
    @Expose
     var results: List<Result>? = null

    override fun toString(): String {
        return "News(status=$status, copyright=$copyright, section=$section, lastUpdated=$lastUpdated, numResults=$numResults, results=$results)"
    }
}