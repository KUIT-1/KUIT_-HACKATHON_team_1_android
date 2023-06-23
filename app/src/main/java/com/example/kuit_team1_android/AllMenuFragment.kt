package com.example.kuit_team1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentMenuBinding

class AllMenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    var starbucksMenuAdapter: starbucksMenuAdapter? = null
    var drinkList : ArrayList<HomeItem> = arrayListOf()
    var allList : ArrayList<HomeItem> = arrayListOf()
    var foodList : ArrayList<HomeItem> = arrayListOf()
    var productList : ArrayList<HomeItem> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDummyData()
        starbucksMenuAdapter = starbucksMenuAdapter(drinkList)
        binding.categoryDrink.setOnClickListener {
            starbucksMenuAdapter = starbucksMenuAdapter((drinkList))
            starbucksMenuAdapter((drinkList)).notifyDataSetChanged()
        }
        binding.categoryFood.setOnClickListener {
            starbucksMenuAdapter = starbucksMenuAdapter((foodList))
            starbucksMenuAdapter((foodList)).notifyDataSetChanged()
        }
        binding.categoryProduct.setOnClickListener {
            starbucksMenuAdapter = starbucksMenuAdapter((productList))
            starbucksMenuAdapter((productList)).notifyDataSetChanged()
        }
        binding.starbucksMenuListRv.adapter = starbucksMenuAdapter
        binding.starbucksMenuListRv.layoutManager = GridLayoutManager(context, 1)
//        starbucksMenuListRv!!.setOnItemClickListener(object : WebtoonAdapter.OnItemClickListener{
//            override fun onItemClick(webtoonInfo: WebtoonCover) {
//                val webtoonbundle = Bundle()
//                val webToonDeatilFragment = WebtoonDetailFragment()
//                val dataJson = Gson().toJson(webtoonInfo)
//                webtoonbundle.putString("webtoonInfo", dataJson)
//                webToonDeatilFragment.arguments = webtoonbundle
//                parentFragment!!.parentFragmentManager.beginTransaction()
//                    .replace(R.id.main_frm, webToonDeatilFragment).commit()
//
//            }
//
//        })
    }
    private fun initDummyData() {
        val dummydata = HomeItem(R.drawable.img,"아메리카노","달달",1)
        drinkList.add(dummydata)
        allList.add(dummydata)
        val dummydata2 = HomeItem(R.drawable.img,"아메리카노2","달달",2)
        foodList.add(dummydata2)
        allList.add(dummydata2)
        val dummydata3 = HomeItem(R.drawable.img,"아메리카노3","달달",3)
        productList.add(dummydata3)
        allList.add(dummydata3)
        starbucksMenuAdapter?.notifyDataSetChanged()
    }
}