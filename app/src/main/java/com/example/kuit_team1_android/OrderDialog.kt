package com.example.kuit_team1_android

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kuit_team1_android.databinding.DialogOrderBinding
import com.google.gson.Gson

class OrderDialog : DialogFragment() {
    lateinit var binding: DialogOrderBinding
//  lateinit var selectedMenu : HomeItem


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogOrderBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity(), R.style.FullscreenDialog)
            .setView(binding.root)

        val selectedMenuJson = arguments?.getString("selectedMenu")
        val selectedMenu = Gson().fromJson(selectedMenuJson, HomeItem::class.java)

        Log.d("testtest", selectedMenu.toString())
        //여기서 개수 지정 후 다음 액티비티로 넘기기


        binding.apply {
            itemNameTv.text = selectedMenu.menuName
            itemPriceTv.text = selectedMenu.menuPrice
            val itemPrice = binding.itemPriceTv.text.toString().toInt() // price 값 연동되면 그 값 쓰기


            itemCountAddIv.setOnClickListener {
                val currentCount = itemCountTv.text.toString().toInt()
                val newCount = currentCount + 1
                itemCountTv.text = newCount.toString()
                val newPrice = itemPrice * newCount
                itemPriceTv.text = newPrice.toString()
            }
            itemCountSubtractIv.setOnClickListener {
                val currentCount = itemCountTv.text.toString().toInt()
                val newCount = currentCount - 1
                if (newCount >= 1) {
                    itemCountTv.text = newCount.toString()
                    val newPrice = itemPrice * newCount
                    itemPriceTv.text = newPrice.toString()
                }
            }

            addShopCartBtn.setOnClickListener {
                Log.d("ClickEvent", "addShopCartBtn")


                val bundle = Bundle()

                val price = itemPriceTv.text.toString()


                val Menu = HomeItem(
                    selectedMenu.menuSrc,
                    selectedMenu.menuName,
                    selectedMenu.menuExp,
                    selectedMenu.menuType,
                    price,
                    price.toInt()/itemPrice
                )
//                val MenuOption =
                val dataJson = Gson().toJson(Menu)
                bundle.putString("Menu", dataJson)

                val intent = Intent(requireContext(), ShopBasketActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                dismiss()
            }

        }


        return builder.create()
    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DialogOrderBinding.inflate(inflater, container, false)
//
//
////        selectedMenu = Gson().fromJson(requireArguments().getString("selectedMenu"),HomeItem::class.java)
////        Log.d("testtest",selectedMenu.toString())
//        //여기서 개수 지정 후 다음 액티비티로 넘기기
//
//
//        binding.addShopCartBtn.setOnClickListener {
//            Log.d("ClickEvent", "addShopCartBtn")
//
//            val intent = Intent(requireContext(), ShopBasketActivity::class.java)
////            val data = Gson().toJson(selectedMenu)
////            intent.putExtra("selectedMenu",data)
//            intent.putExtra("number", 2)
//            startActivity(intent)
//            dismiss()
//        }
//
//        return binding.root
//    }
}