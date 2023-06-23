package com.example.kuit_team1_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.FragmentOrderBinding
import com.example.kuit_team1_android.databinding.FragmentShopBasketDetailBinding
import com.google.gson.Gson

class ShopBasketDetailFragment : Fragment() {
    lateinit var binding : FragmentShopBasketDetailBinding
    var detailAdapter: OrderMenuAdapter? = null
    private var orderList = ArrayList<HomeItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopBasketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("test1234", Gson().fromJson(requireArguments().getString("selectedMenu"), HomeItem::class.java).toString())
        orderList.add(HomeItem(R.drawable.americano,"아메리카노","꿀맛",1,"4400"))
        detailAdapter = OrderMenuAdapter(orderList)
        binding.orderMenuListRv.adapter = detailAdapter
        binding.orderMenuListRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


//        if (장바구니에 아이템 없으면 // 받은 데이터 비어있으면){
//            shopbasket_blank_img 로 바꿔두기
//        }

}