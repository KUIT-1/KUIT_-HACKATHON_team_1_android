package com.example.kuit_team1_android

import com.example.naverwebtoon.data.Member
import com.example.naverwebtoon.data.MemberResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitInterface {
    @POST("/members")
    fun signUp(
        @Body member: Member
    ): Call<MemberResponse>

    @GET("/members/{id}")
    fun getMember(
        @Path("id") id : Int
    ): Call<MemberResponse>
}