package com.example.kuit_team1_android

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit_team1_android.databinding.ActivitySearchMenuBinding
import com.example.kuit_team1_android.databinding.ActivityShopBasketBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchMenuActivity : AppCompatActivity() {
    lateinit var binding : ActivitySearchMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchMenuBinding.inflate(layoutInflater)

        binding.searchMenuTextEd.setSelection(0)
        setContentView(binding.root)
        binding.searchCancelBtn.setOnClickListener {
            finish()
        }
    }
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // 뒤로 버튼 이벤트 처리

        }
    }
}