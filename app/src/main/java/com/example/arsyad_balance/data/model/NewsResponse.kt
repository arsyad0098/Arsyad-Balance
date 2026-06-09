package com.example.arsyad_balance.data.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val success: Boolean,
    val message: String?,
    val data: List<NewsPost>
)

data class NewsPost(
    val link: String?,
    val title: String?,
    val pubDate: String?,
    
    @SerializedName("contentSnippet")
    val description: String?,
    
    @SerializedName("image")
    val thumbnail: Any?
)
