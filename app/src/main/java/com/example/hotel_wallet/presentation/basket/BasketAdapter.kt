package com.example.hotel_wallet.presentation.basket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel_wallet.data.source.local.Basket
import com.example.hotel_wallet.databinding.RowItemDetailBinding

class BasketAdapter(
    private val menuList: List<Basket>,
    private val viewModel: BasketViewModel
) : RecyclerView.Adapter<BasketAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = RowItemDetailBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        with(holder) {
            with(menuList[position]) {
                binding.menuName.text = name
                binding.menuPrice.text = price
                binding.menuQty.text = quantity
                Glide.with(itemView)
                    .load(image)
                    .into(binding.thumbImage)

                binding.ivDelete.setOnClickListener {
                    viewModel.deleteFavorite(menuList[position])
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }


    inner class MenuViewHolder(val binding: RowItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root)

}




