package com.example.kuit_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

//        initDummyData()
        init()
    }

    fun init() {
        binding.homeHorizontalRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.homeHorizontalRv.adapter = HomeAdapter(itemList)

        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            tempBtn.setOnClickListener {
                isIced = !isIced
                updatetemp(isIced)
            }
            itemDetailOrderBtn.setOnClickListener {
                // 주문 다이얼로그로 넘어가야함


                val bundle = Bundle()
                val itemName = itemNameKorTv.text.toString()
                val itemPrice = itemPriceTv.text.toString()
                val itemImg = itemDetailImgIv.toString()

                val selectedMenu = HomeItem(itemImg, itemName, "", 0, itemPrice)
                val dataJson = Gson().toJson(selectedMenu)
                bundle.putString("selectedMenu", dataJson)

                // OrderDialog 호출
                val dialog = OrderDialog()
                dialog.arguments = bundle
                dialog.show(supportFragmentManager, "OrderDialog")


//                val dataJson = intent.getStringExtra("selectedMenu")
//                val OrderData = Gson().fromJson(dataJson, HomeItem::class.java)
//                val dataJson2 = Gson().toJson(OrderData)
//                bundle.putString("selectedMenu", dataJson2)
//                val dialog = Dialog(this@ItemDetailActivity)
//                dialog.setContentView(R.layout.dialog_order) // 다이얼로그 레이아웃 설정
//                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//
//                dialog.show()


                // OrderDialog 호출
//                val dialog = OrderDialog()
//                dialog.arguments = bundle
//                dialog.show(supportFragmentManager, "OrderDialog")

            }
        }
    }

    fun updatetemp(state: Boolean) {
//        userDB.UserDao().updateAlarmed(isAlarmed, getUserId(requireContext()), webtoonInfo.id)
        if (!state) {
            binding.iceIv.visibility = View.GONE
            binding.hotIv.visibility = View.VISIBLE
            binding.itemNameTempTv.visibility = View.GONE
            binding.itemDetailImgIv.setImageResource(R.drawable.hot_americano)
        } else {
            binding.iceIv.visibility = View.VISIBLE
            binding.hotIv.visibility = View.GONE
            binding.itemNameTempTv.visibility = View.GONE
            binding.itemDetailImgIv.setImageResource(R.drawable.item_ex_img)
        }
    }

//    fun initDummyData(){
//        val dummydata = HomeItem(R.drawable.home_img4, "아메리카노", "", 0,"4000")
//        itemList.add(dummydata)
//        itemList.add(dummydata)
//        itemList.add(dummydata)
//    }

}