package com.example.kuit_team1_android

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ShopBasketVPAdapter(activity: ShopBasketActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {


        return when(position){
            1 -> ShopBasketDetailFragment()
            2 -> ShopBasketItemFragment()
            else -> ShopBasketDetailFragment()
        }


    }
}