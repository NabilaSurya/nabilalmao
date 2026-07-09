package com.example.nabila_lmao.pertemuan_11

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getNews(): Call<List<News>>

}