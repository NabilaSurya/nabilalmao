package com.example.nabila_lmao.pertemuan_11

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val instance: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(
                "https://jsonplaceholder.typicode.com/"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(ApiService::class.java)
    }
}