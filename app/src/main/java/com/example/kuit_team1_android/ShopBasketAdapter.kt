package com.example.kuit_team1_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit_team1_android.databinding.ItemHomeRecBinding
import com.example.kuit_team1_android.databinding.ItemOrderMenuBinding

class ShopBasketAdapter(private var itemList: ArrayList<HomeItem>) :
    RecyclerView.Adapter<ShopBasketAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(homeItem: HomeItem)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemOrderMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: HomeItem) {
            binding.itemOrderMenuNameTv.text = itemList.menuName
//            Glide.with(binding.root).load(itemList.menuSrc).into(binding.itemOrderMenuIv3)
            binding.itemOrderMenuIv3.setImageResource(R.drawable.item_ex_img)
            binding.itemOrderMenuPriceTv.text = itemList.menuPrice
            binding.orderCountTv.text = itemList.menuNum.toString()
            binding.itemOrderMenuDescription.text = itemList.menuExp

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemOrderMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])

    }
}
