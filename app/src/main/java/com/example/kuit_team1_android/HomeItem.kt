package com.example.kuit_team1_android

import com.google.gson.annotations.SerializedName

data class HomeItem(
    @SerializedName("menuSrc") val menuSrc: String,
    @SerializedName("menuName") val menuName: String,
    @SerializedName("menuExp") val menuExp: String,
    @SerializedName("menuType") val menuType: Int,
    @SerializedName("menuPrice") val menuPrice: String
)

data class HomeItemResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: HomeResult,
)

data class HomeResult(
    @SerializedName("recommendMenuDtos") val recommendMenuDtos: List<RecommendMenuDto>
)

data class categoryResult(
    @SerializedName("subCategoryList") val categoryDto: List<categoryDto>
)
data class categoryDto(
    @SerializedName("id") val id : Int,
    @SerializedName("name_kr") val name_kr : String,
    @SerializedName("name_eng") val name_eng : String,
    @SerializedName("image_url") val image_url : String,
)

data class RecommendMenuDto(
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String
)

data class SelectedResult(
    @SerializedName("subCategoryList") val subCategoryList: List<SubCategoryList>
)

data class SubCategoryList(
    @SerializedName("id") val id: Int,
    @SerializedName("name_kr") val name_kr: String,
    @SerializedName("name_eng") val name_eng: String
)
