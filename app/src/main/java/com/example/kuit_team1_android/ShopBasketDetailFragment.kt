package com.example.kuit_team1_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

class ShopBasketDetailFragment : Fragment() {
    var detailAdapter: OrderMenuAdapter? = null
    private var orderList = ArrayList<HomeItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_basket_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test1234", this.requireArguments().toString())
        detailAdapter = OrderMenuAdapter(orderList)
//        binding.detailWebtoonListRv.adapter = detailAdapter
//        binding.detailWebtoonListRv.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


//        if (장바구니에 아이템 없으면 // 받은 데이터 비어있으면){
//            shopbasket_blank_img 로 바꿔두기
//        }

}