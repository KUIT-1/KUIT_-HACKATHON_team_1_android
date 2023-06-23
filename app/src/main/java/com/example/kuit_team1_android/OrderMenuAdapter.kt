package com.example.kuit_team1_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit_team1_android.databinding.ItemOrderMenuBinding
import com.example.kuit_team1_android.databinding.ItemStarbucksMenuBinding

class OrderMenuAdapter(private val itemList: ArrayList<HomeItem>) :
    RecyclerView.Adapter<OrderMenuAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(menuInfo: HomeItem)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemOrderMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuInfo: HomeItem) {
            binding.itemOrderMenuNameTv.text = menuInfo.menuName
            binding.itemOrderMenuDescription.text = menuInfo.menuExp
            Glide.with(binding.root).load(menuInfo.menuSrc).into(binding.itemOrderMenuIv3)
            binding.itemOrderMenuPriceTv.text = menuInfo.menuPrice
            binding.itemOrderMenuCl.setOnClickListener {
                itemClickListener.onItemClick(menuInfo)
            }
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