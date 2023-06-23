package com.example.kuit_team1_android

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.lang.reflect.Member

interface RetrofitInterface {
    @POST("/members") //변경필요
    fun signUp(
        @Body homeItem: HomeItem
    ): Call<HomeItem>

    @GET("/members/{id}") //변경필요
    fun getMember(
        @Path("id") id : Int
    ): Call<HomeItem>
}