package com.example.kuit_team1_android

import com.google.gson.annotations.SerializedName

data class HomeItem(
    @SerializedName("menuSrc") val menuSrc:Int,
    @SerializedName("menuName") val menuName: String,
    @SerializedName("menuExp") val menuExp:String,
    @SerializedName("menuType") val menuType:Int,
    @SerializedName("menuType") val menuPrice:String
)
data class HomeItemResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: MemberResult,
)
data class MemberResult(
    @SerializedName("id") val id: Int,
    @SerializedName("email_id") val emailId: String,
    @SerializedName("name") val name: String,
    @SerializedName("birth") val birth: String,
    @SerializedName("gender") val gender: String,
    )
