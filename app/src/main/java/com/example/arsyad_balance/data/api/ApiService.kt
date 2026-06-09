package com.example.arsyad_balance.data.api

import com.example.arsyad_balance.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/cnn-news/nasional")
    fun getNews(): Call<NewsResponse>
}
