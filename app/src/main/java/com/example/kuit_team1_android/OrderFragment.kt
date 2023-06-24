package com.example.kuit_team1_android

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit_team1_android.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Response

class OrderFragment : Fragment() {
    lateinit var binding: FragmentOrderBinding
    var menuList : ArrayList<HomeItem> = arrayListOf()
    var pagerHandler = Handler(Looper.getMainLooper())


    private val categoyList = listOf<String>("전체 메뉴","나만의 메뉴")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        binding.shopbasketBtn.setOnClickListener {
            val intent = Intent(requireContext(), ShopBasketActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.iconSearchIv.setOnClickListener {
            val intent = Intent(requireContext(),SearchMenuActivity::class.java)
            startActivity(intent)
        }
        
//        menuList.add(HomeItem(R.drawable.img,"아메리카노","달달구리",1,"4000"))
        val starbucksMenuAdapter = starbucksMenuVPAdapter(this)
        binding.starbucksMenuListVp.adapter = starbucksMenuAdapter
        TabLayoutMediator(binding.starbucksCategoryTb,binding.starbucksMenuListVp){
                tab,pos ->
            tab.text = categoyList[pos]
        }.attach()
    }




}