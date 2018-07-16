package com.meteoro.kedditlearn.api

import retrofit2.Call

/**
 * News API
 * */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}