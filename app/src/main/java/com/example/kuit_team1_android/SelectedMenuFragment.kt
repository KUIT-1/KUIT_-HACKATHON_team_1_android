package com.example.kuit_team1_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kuit_team1_android.databinding.FragmentMenuBinding
import com.example.kuit_team1_android.databinding.FragmentSelectedMenuBinding
import com.google.gson.Gson

class SelectedMenuFragment : Fragment() {
    lateinit var binding: FragmentSelectedMenuBinding
    var starbucksMenuAdapter: starbucksMenuAdapter? = null
    var drinkList: ArrayList<HomeItem> = arrayListOf()
    var allList: ArrayList<HomeItem> = arrayListOf()
    var foodList: ArrayList<HomeItem> = arrayListOf()
    var productList: ArrayList<HomeItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedMenuBinding.inflate(inflater, container, false)
        initDummyData()
        init()
        binding.selectedResultTitle.text = allList[0].menuName
        binding.selectedMenuBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_frm,OrderFragment()).commit()
        }
        binding.selectedMenuSearchBtn.setOnClickListener {
            val intent = Intent(requireContext(),SearchMenuActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
    private fun init() {
        starbucksMenuAdapter = starbucksMenuAdapter(allList)


        binding.selectedMenuListRv.adapter = starbucksMenuAdapter
        binding.selectedMenuListRv.layoutManager = GridLayoutManager(context, 1)


        starbucksMenuAdapter!!.setOnItemClickListener(object: starbucksMenuAdapter.OnItemClickListener{
            override fun onItemClick(menuInfo: HomeItem) {
                val dataJson =Gson().toJson(menuInfo)
                val intent = Intent(requireContext(), ItemDetailActivity::class.java)
                intent.putExtra("selectedMenu",dataJson)
                startActivity(intent)

            }
        })


    }
    private fun initDummyData() {
        val dummydata = HomeItem(R.drawable.americano, "아메리카노", "달달", 1,"4000")
//        drinkList.add(dummydata)

        allList.add(dummydata)
        val dummydata2 = HomeItem(R.drawable.americano, "아메리카노2", "달달", 2,"4000")
//        foodList.add(dummydata2)

        allList.add(dummydata2)
        val dummydata3 = HomeItem(R.drawable.americano, "아메리카노3", "달달", 3,"4000")
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