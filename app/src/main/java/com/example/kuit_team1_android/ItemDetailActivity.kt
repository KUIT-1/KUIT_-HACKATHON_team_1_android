package com.example.kuit_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kuit_team1_android.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}