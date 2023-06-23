package com.example.kuit_team1_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_team1_android.databinding.ItemStarbucksMenuBinding

class starbucksMenuAdapter(private val itemList: ArrayList<HomeItem>) :
    RecyclerView.Adapter<starbucksMenuAdapter.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(menuInfo: HomeItem)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemStarbucksMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuInfo: HomeItem) {
            binding.itemStarbucksMenuNameTv.text = menuInfo.menuName
            binding.itemStarbucksMenuDescription.text = menuInfo.menuExp
            binding.itemStarbucksMenuIv3.setImageResource(menuInfo.menuSrc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemStarbucksMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}