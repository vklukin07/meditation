package com.example.meditation.recycAdapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class myRetrofit {
    fun getRetrofit()= Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hakta.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

// "http://mskko2021.mad.hakta.pro/api/user/login"