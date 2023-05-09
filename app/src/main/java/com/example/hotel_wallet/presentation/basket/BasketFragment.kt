package com.example.hotelwallet.presentation.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotel_wallet.data.source.local.Basket
import com.example.hotel_wallet.databinding.FragmentBasketBinding
import com.example.hotel_wallet.presentation.basket.BasketAdapter
import com.example.hotel_wallet.presentation.basket.BasketViewModel
import com.example.hotel_wallet.presentation.misc.BaseFragment

class BasketFragment : BaseFragment<FragmentBasketBinding>(
    FragmentBasketBinding::inflate
) {

    private lateinit var detailMenuAdapter: BasketAdapter
    private val basketViewModel: BasketViewModel by viewModels()
    private var detailList = mutableListOf<Basket>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basketViewModel.allFavorites
        detailMenuAdapter = BasketAdapter(emptyList(), basketViewModel)
        binding.recyclerViewSaved.setHasFixedSize(true)
        binding.recyclerViewSaved.isNestedScrollingEnabled = false
        binding.recyclerViewSaved.adapter = detailMenuAdapter
        binding.recyclerViewSaved.layoutManager = LinearLayoutManager(requireContext())

        basketViewModel.allFavorites.observe(viewLifecycleOwner) { basket ->
            detailMenuAdapter = BasketAdapter(basket, basketViewModel)
            binding.recyclerViewSaved.adapter = detailMenuAdapter
            val totalPrice = calculateTotalPrice(basket)
            binding.totalCartPriceTextView.text = "Total: $$totalPrice"
        }

    }

    fun calculateTotalPrice(menuItems: List<Basket>): Int {
        var totalPrice = 0
        for (menuItem in menuItems) {
            totalPrice += menuItem.price.toInt() * menuItem.quantity.toInt()
        }
        return totalPrice
    }
}
