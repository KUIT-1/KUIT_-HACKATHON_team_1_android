package com.example.kuit_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit_team1_android.databinding.ActivityShopBasketBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import kotlin.math.ceil

class ShopBasketActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopBasketBinding

    private val categoryList = listOf<String>("음료/푸드", "상품")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBasketBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        val dataJson = intent.getStringExtra("selectedMenu")
//        val orderData = Gson().fromJson(dataJson, HomeItem::class.java)


        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }

            val bundle = intent.extras
            if (bundle != null) {
                // 번들에서 데이터 추출
                val dataJson = bundle.getString("Menu")
                val orderMenu = Gson().fromJson(dataJson, HomeItem::class.java)
                Log.d("ShopBasketActivity_Bundle", orderMenu.toString())

                // 추출한 데이터 활용
                val menuName = orderMenu.menuName
                val menuPrice = orderMenu.menuPrice


            }
        }


        val shopBasketVPAdapter = ShopBasketVPAdapter(this)
        binding.shopbasketVp.adapter = shopBasketVPAdapter
        TabLayoutMediator(binding.shopbasketTb, binding.shopbasketVp) { tab, position ->
            tab.text = categoryList[position]
        }.attach()

    }


}