package com.example.meditation.recycAdapter

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface myInterface {
    @POST("user/login")
    fun postLogin(@Body hashMap: HashMap<String,String>) : Call<logins>
    @GET("feelings")
    fun getFeel():Call<feelings>
    @GET("quotes")
    fun getQuotes():Call<quotes>
}