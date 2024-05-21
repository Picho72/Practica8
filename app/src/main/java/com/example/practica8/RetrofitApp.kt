package com.example.practica8

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApp {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(IContacto.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
