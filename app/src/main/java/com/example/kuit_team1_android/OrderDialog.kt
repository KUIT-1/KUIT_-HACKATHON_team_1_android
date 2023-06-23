package com.example.kuit_team1_android

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kuit_team1_android.databinding.DialogOrderBinding

class OrderDialog : DialogFragment() {
    lateinit var binding: DialogOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DialogOrderBinding.inflate(inflater, container, false)

        binding.addShopCartBtn.setOnClickListener {
            val intent = Intent(requireContext(), ShopBasketActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}