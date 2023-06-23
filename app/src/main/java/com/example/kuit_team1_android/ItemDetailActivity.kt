package com.example.kuit_team1_android

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_team1_android.databinding.ActivityItemDetailBinding
import com.google.gson.Gson

class ItemDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailBinding
    lateinit var layoutManager: LinearLayoutManager
    var itemList: ArrayList<HomeItem> = arrayListOf()
    var isIced = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDummyData()
        init()
    }

    fun init() {
        binding.homeHorizontalRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.homeHorizontalRv.adapter = HomeAdapter(itemList)

        binding.apply {
            tempBtn.setOnClickListener {
                isIced = !isIced
                updatetemp(isIced)
            }
            itemDetailOrderBtn.setOnClickListener {
                // 주문 다이얼로그로 넘어가야함
                val bundle = Bundle()


                webToonDeatilFragment.arguments = webtoonbundle

                val dataJson = intent.getStringExtra("selectedMenu")
                val OrderData = Gson().fromJson(dataJson, HomeItem::class.java)
                val dataJson = Gson().toJson(OrderData)
                bundle.putString("selectedMenu", dataJson)
                val dialog = Dialog(this@ItemDetailActivity)

                dialog.setContentView(R.layout.dialog_order) // 다이얼로그 레이아웃 설정
                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

                dialog.show()

            }
        }
    }

    fun updatetemp(state: Boolean) {
//        userDB.UserDao().updateAlarmed(isAlarmed, getUserId(requireContext()), webtoonInfo.id)
        if (!state) {
            binding.iceIv.visibility = View.GONE
            binding.hotIv.visibility = View.VISIBLE
            binding.itemDetailImgIv.setImageResource(R.drawable.hot_americano)
        } else {
            binding.iceIv.visibility = View.VISIBLE
            binding.hotIv.visibility = View.GONE
            binding.itemDetailImgIv.setImageResource(R.drawable.item_ex_img)
        }
    }

    fun initDummyData(){
        val dummydata = HomeItem(R.drawable.home_img4, "아메리카노", "", 0,"4000")
        itemList.add(dummydata)
        itemList.add(dummydata)
        itemList.add(dummydata)
    }

}