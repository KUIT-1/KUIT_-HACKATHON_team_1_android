package com.example.kuit_team1_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var layoutManager: LinearLayoutManager
    var itemList: ArrayList<HomeItem> = arrayListOf()
    var menuname = ""
    var menuImg = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val menu = "recommend"


//        initDummyData()
        setRecmenu(menu)
        init()
        initClick()
        return binding.root
    }

    private fun setRecmenu(menu: String) {
        val memberService = getRetrofit().create(RetrofitInterface::class.java)
        memberService.getHome(menu).enqueue(object :retrofit2.Callback<HomeResult>{
            override fun onResponse(
                call: Call<HomeResult>,
                response: Response<HomeResult>
            ) {
                if (response.isSuccessful){
                    val resp = response.body()
                    Log.i("GETUSERID/SUCCESS", resp.toString())

                    val menuDtos = resp?.recommendMenuDtos
                    if (menuDtos != null) {
                        for (menuDto in menuDtos) {
                            val menuName = menuDto.name
                            val imageUrl = menuDto.imageUrl
                            itemList.add(HomeItem(imageUrl, menuName, "", 0, ""))
                        }
                        // itemList이 변경되었으므로 어댑터에 변경을 알려줘야 함
                        binding.homeHorizontalRv.adapter?.notifyDataSetChanged()
                    }
//                    menuname = resp!!.result.name
//                    menuImg = resp!!.result.img
//                    itemList.add(HomeItem(menuImg.toString(),menuname, "", 0, ""))
                }
            }

            override fun onFailure(call: Call<HomeResult>, t: Throwable) {
                Log.i("GETUSERID/FAILURE", "fail!!")
            }

        })
    }

    private fun initClick() {

        //이거 지워야함
        binding.apply {
            homeLoginBtn.setOnClickListener {
                val intent = Intent(requireContext(), ItemDetailActivity::class.java)
                startActivity(intent)
            }
        }
        //
    }

    fun init() {
        binding.homeHorizontalRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeHorizontalRv.adapter = HomeAdapter(itemList)
    }


//    fun initDummyData(){
//        val dummydata = HomeItem(R.drawable.home_img4, "햄&루꼴라 올리브 샌드위치", "", 0,"4000")
//        itemList.add(dummydata)
//        itemList.add(dummydata)
//        itemList.add(dummydata)
//    }


}