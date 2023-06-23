package com.example.kuit_team1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var layoutManager: LinearLayoutManager
    var itemList: ArrayList<HomeItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initDummyData()
        init()
        return binding.root
    }

    fun init() {
        binding.homeHorizontalRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeHorizontalRv.adapter = HomeAdapter(itemList)
    }


    fun initDummyData(){
        val dummydata = HomeItem(R.drawable.home_img2, "아메리카노", "", 0)
        itemList.add(dummydata)
    }


}