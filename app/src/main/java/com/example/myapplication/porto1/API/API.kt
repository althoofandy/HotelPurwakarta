package com.example.myapplication.porto1.API

import com.example.myapplication.porto1.Response.HotelResponse
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("hotel")
    fun hotel(): Call<HotelResponse>
}