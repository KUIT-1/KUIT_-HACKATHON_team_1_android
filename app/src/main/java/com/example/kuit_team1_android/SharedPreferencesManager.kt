package com.example.kuit_team1_android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity


fun saveUserId(context: Context, id: String){
    val spf = context.getSharedPreferences("Myspf", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userId", id)
    editor.apply()
}

fun getUserId(context: Context): String{
    val spf = context.getSharedPreferences("Myspf", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userId", "default-user18247390487")!!
}

fun setMenuName(context: Context, name: String){
    val spf = context.getSharedPreferences("menu_spf", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("menuName", name)
    editor.apply()
}

fun getMenuName(context: Context): String{
    val spf = context.getSharedPreferences("menu_spf", AppCompatActivity.MODE_PRIVATE)
    return spf.getString("menuName", "")!!
}