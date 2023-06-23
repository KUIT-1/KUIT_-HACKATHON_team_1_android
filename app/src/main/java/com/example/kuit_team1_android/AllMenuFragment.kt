package com.example.kuit_team1_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentMenuBinding
import retrofit2.Call
import retrofit2.Response

class AllMenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding
    var starbucksMenuAdapter: starbucksMenuAdapter? = null
    var drinkList: ArrayList<HomeItem> = arrayListOf()
    var allList: ArrayList<HomeItem> = arrayListOf()
    var foodList: ArrayList<HomeItem> = arrayListOf()
    var productList: ArrayList<HomeItem> = arrayListOf()
    var homeItem = ArrayList<HomeItem>()
    var itemList: ArrayList<HomeItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        setCategory(1)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        initDummyData()
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
                parentFragment!!.parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, SelectedMenuFragment()).commit()
            }
        })


    }
    private fun setCategory(id: Int) {
        val memberService = getRetrofit().create(RetrofitInterface::class.java)
        memberService.getcategory(id).enqueue(object :retrofit2.Callback<categoryResult>{
            override fun onResponse(
                call: Call<categoryResult>,
                response: Response<categoryResult>
            ) {
                if (response.isSuccessful){
                    val resp = response.body()
                    Log.i("GETUSERID/SUCCESS", resp.toString())

                    val menuDtos = resp?.categoryDto
                    if (menuDtos != null) {
                        for (menuDto in menuDtos) {
                            val catid = menuDto.id
                            val kor = menuDto.name_kr
                            val eng = menuDto.name_eng
                            val img = menuDto.image_url
                            itemList.add(HomeItem(img, kor, eng, 0, ""))
                        }
                        // itemList이 변경되었으므로 어댑터에 변경을 알려줘야 함
                        binding.starbucksMenuListRv.layoutManager = GridLayoutManager(requireContext(),GridLayoutManager.VERTICAL,1,false)

                        binding.starbucksMenuListRv.adapter = starbucksMenuAdapter(itemList)
                    }
//                    menuname = resp!!.result.name
//                    menuImg = resp!!.result.img
//                    itemList.add(HomeItem(menuImg.toString(),menuname, "", 0, ""))
                }
            }

            override fun onFailure(call: Call<categoryResult>, t: Throwable) {
                Log.i("GETUSERID/FAILURE", t.message.toString())
            }

        })
    }

//
//    private fun initDummyData() {
//        val dummydata = HomeItem(R.drawable.americano, "아메리카노", "달달", 1,"4000")
////        drinkList.add(dummydata)
//
//        allList.add(dummydata)
//        val dummydata2 = HomeItem(R.drawable.americano, "아메리카노2", "달달", 2,"4100")
////        foodList.add(dummydata2)
//
//        allList.add(dummydata2)
//        val dummydata3 = HomeItem(R.drawable.americano, "아메리카노3", "달달",2,"4200")
////        productList.add(dummydata3)
//
//        allList.add(dummydata3)
//
//        for (i in 0..allList.size - 1) {
//            if (allList[i].menuType == 1) {
//                drinkList.add(allList[i])
//            } else if (allList[i].menuType == 2) {
//                foodList.add(allList[i])
//            } else {
//                productList.add(allList[i])
//            }
//        }
//
//
//        starbucksMenuAdapter?.notifyDataSetChanged()
//    }

}