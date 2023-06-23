package com.example.kuit_team1_android

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentMenuBinding
import java.util.Objects

class AllMenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    var starbucksMenuAdapter: starbucksMenuAdapter? = null
    var drinkList: ArrayList<HomeItem> = arrayListOf()
    var allList: ArrayList<HomeItem> = arrayListOf()
    var foodList: ArrayList<HomeItem> = arrayListOf()
    var productList: ArrayList<HomeItem> = arrayListOf()
    var homeItem = ArrayList<HomeItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initDummyData()
        init()

    }

    private fun init() {
        starbucksMenuAdapter = starbucksMenuAdapter(drinkList)

        binding.categoryDrink.setOnClickListener {
            Log.d("ClickEvent", "drink")
            Log.d("ListSize", drinkList.size.toString())

            starbucksMenuAdapter = starbucksMenuAdapter((drinkList))
            binding.starbucksMenuListRv.adapter = starbucksMenuAdapter

            starbucksMenuAdapter((drinkList)).notifyDataSetChanged()
        }
        binding.categoryFood.setOnClickListener {
            Log.d("ClickEvent", "food")
            Log.d("FoodListSize", foodList.size.toString())


            starbucksMenuAdapter = starbucksMenuAdapter((foodList))
            binding.starbucksMenuListRv.adapter = starbucksMenuAdapter

            starbucksMenuAdapter((foodList)).notifyDataSetChanged()
        }
        binding.categoryProduct.setOnClickListener {
            Log.d("ClickEvent", "product")

            starbucksMenuAdapter = starbucksMenuAdapter((productList))
            binding.starbucksMenuListRv.adapter = starbucksMenuAdapter

            starbucksMenuAdapter((productList)).notifyDataSetChanged()
        }

        binding.starbucksMenuListRv.adapter = starbucksMenuAdapter
        binding.starbucksMenuListRv.layoutManager = GridLayoutManager(context, 1)


        starbucksMenuAdapter!!.setOnItemClickListener(object: starbucksMenuAdapter.OnItemClickListener{
            override fun onItemClick(menuInfo: HomeItem) {
                val intent = Intent(requireContext(), ItemDetailActivity::class.java)
                startActivity(intent)
            }

        })


    }


    private fun initDummyData() {
        val dummydata = HomeItem(R.drawable.img, "아메리카노", "달달", 1)
//        drinkList.add(dummydata)

        allList.add(dummydata)
        val dummydata2 = HomeItem(R.drawable.img, "아메리카노2", "달달", 2)
//        foodList.add(dummydata2)

        allList.add(dummydata2)
        val dummydata3 = HomeItem(R.drawable.img, "아메리카노3", "달달", 3)
//        productList.add(dummydata3)

        allList.add(dummydata3)

        for (i in 0..allList.size - 1) {
            if (allList[i].menuType == 1) {
                drinkList.add(allList[i])
            } else if (allList[i].menuType == 2) {
                foodList.add(allList[i])
            } else {
                productList.add(allList[i])
            }
        }


        starbucksMenuAdapter?.notifyDataSetChanged()
    }

}