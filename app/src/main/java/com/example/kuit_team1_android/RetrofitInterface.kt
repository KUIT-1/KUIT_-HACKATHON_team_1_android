package com.example.kuit_team1_android

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitInterface {
    @GET("/members/{id}")
    fun getMember(
        @Path("id") id : Int
    ): Call<HomeItemResponse>
}