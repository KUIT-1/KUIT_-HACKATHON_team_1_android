package com.example.kuit_team1_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_team1_android.databinding.ItemHomeRecBinding

class HomeAdapter(private var itemList: ArrayList<HomeItem>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(homeItem: HomeItem)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemHomeRecBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: HomeItem) {
            binding.itemNameTv.text = itemList.menuName
            binding.itemImgIv.setImageResource(itemList.menuSrc)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])

    }
}
