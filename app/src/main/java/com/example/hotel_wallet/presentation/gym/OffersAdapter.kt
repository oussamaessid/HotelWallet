package com.example.hotel_wallet.presentation.gym

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotel_wallet.databinding.RowItemOfferBinding
import com.example.hotel_wallet.domain.model.Gym

class OffersAdapter(
    private val popularList: List<Gym>,
    private val listener: (Gym) -> Unit
) : RecyclerView.Adapter<OffersAdapter.OfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = RowItemOfferBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        with(holder) {
            with(popularList[position]) {
                Glide.with(itemView)
                    .load(image)
                    .into(binding.imgOrder)
                binding.txtName.text = description
                binding.txtUserName.text = nom
                binding.txtPrice.text = prix

                binding.btnAdd.setOnClickListener {
                    listener(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    inner class OfferViewHolder(val binding: RowItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root)

}