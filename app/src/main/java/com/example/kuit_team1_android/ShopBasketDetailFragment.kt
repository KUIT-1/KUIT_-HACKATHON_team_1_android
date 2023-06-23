package com.example.kuit_team1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShopBasketDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_basket_detail, container, false)
    }


//        if (장바구니에 아이템 없으면 // 받은 데이터 비어있으면){
//            shopbasket_blank_img 로 바꿔두기
//        }

}