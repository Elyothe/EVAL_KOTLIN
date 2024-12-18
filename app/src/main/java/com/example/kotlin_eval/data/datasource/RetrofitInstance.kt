package com.example.kotlin_eval.data.datasource

import com.example.kotlin_eval.data.datasource.ApiService

import okhttp3.OkHttpClient
import retrofit2.create

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://valorant-api.com/v1/"

    private val client = OkHttpClient.Builder().build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //Crée l'instance de Retrofit
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}