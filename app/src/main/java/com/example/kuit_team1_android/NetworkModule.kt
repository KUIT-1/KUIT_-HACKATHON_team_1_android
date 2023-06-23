package com.example.kuit_team1_android

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://ebd7-2001-e60-901c-eec-e0-2d4d-40f0-6ccd.jp.ngrok.io"

fun okHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return builder.addInterceptor(logging).build()
}

fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient()).build()
    return retrofit
}