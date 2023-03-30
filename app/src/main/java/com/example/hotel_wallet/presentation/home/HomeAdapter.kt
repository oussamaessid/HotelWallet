package com.example.hotel_wallet.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel_wallet.databinding.RowItemCategoryBinding
import com.example.hotel_wallet.domain.model.Service


class HomeAdapter(
    private var menuList: List<Service>,
    private val listener: (Service) -> Unit
) : RecyclerView.Adapter<HomeAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = RowItemCategoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        with(holder) {
            with(menuList[position]) {
                binding.txtCategoryName.text = title
                Glide.with(itemView)
                    .load(image)
                    .into(binding.imgCategory)

                itemView.setOnClickListener {
                    listener(this)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun setFilteredList(menuList: List<Service>) {
        this.menuList = menuList
        notifyDataSetChanged()
    }

    inner class MenuViewHolder(val binding: RowItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)


}




