package com.example.kuit_team1_android

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class starbucksMenuVPAdapter(fragment : Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> AllMenuFragment()
            2 -> AllMenuFragment()
            else -> AllMenuFragment()
        }
    }

}