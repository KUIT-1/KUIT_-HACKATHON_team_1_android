package com.example.kuit_team1_android

import retrofit2.Call
import retrofit2.http.*
import java.lang.reflect.Member

interface RetrofitInterface {
    @POST("/members") //변경필요
    fun signUp(
        @Body homeItem: HomeItem
    ): Call<HomeItem>

    @GET("/menu/{menu}") //변경필요
    fun getHome(
        @Path("menu") menu : String
    ): Call<HomeResult>

    @GET("/menu/mainCategory") //변경필요
    fun getcategory(
        @Query("id") menu : Int
    ): Call<categoryResult>

}