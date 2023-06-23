package com.example.kuit_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit_team1_android.databinding.ActivityShopBasketBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.ceil

class ShopBasketActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopBasketBinding

    private val categoryList = listOf<String>("음료/푸드", "상품")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBasketBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val shopBasketVPAdapter = ShopBasketVPAdapter(this)
        binding.shopbasketVp.adapter = shopBasketVPAdapter
        TabLayoutMediator(binding.shopbasketTb, binding.shopbasketVp) { tab, position ->
            tab.text = categoryList[position]
        }.attach()

    }


}