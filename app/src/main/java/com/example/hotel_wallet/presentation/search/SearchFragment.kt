package com.example.hotel_wallet.presentation.search

import android.os.Bundle
import android.view.View
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentSearchBinding
import com.example.hotel_wallet.domain.model.Service
import com.example.hotel_wallet.presentation.home.HomeAdapter
import com.example.hotel_wallet.presentation.misc.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
) {
    private lateinit var homeAdapter: HomeAdapter
    private var menuList = mutableListOf<Service>()
    private lateinit var query : String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getMealInformationFromIntent()


        menuList.clear()
//        homeAdapter = HomeAdapter(menuList) { type ->
//            if (type.type == CATEGORY_EAT) {
//                findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
//            } else {
//                findNavController().navigate(R.id.action_homeFragment_to_gymFragment)
//
//            }
//        }

        binding.recyclerViewService.setHasFixedSize(true)
        binding.recyclerViewService.isNestedScrollingEnabled = false
        setSlideList()
        binding.recyclerViewService.adapter = homeAdapter

//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                filterList(query)
//                return false
//            }
//        })

    }

//   private fun filterList(query: String?) {
//
//    if (query != null) {
//        val filteredList = java.util.ArrayList<Service>()
//        for (i in menuList) {
//            if (i.title.lowercase(Locale.ROOT).contains(query)) {
//                filteredList.add(i)
//            }
//        }
//
//        if (filteredList.isEmpty()) {
//            Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
//        } else {
//            homeAdapter.setFilteredList(filteredList)
//        }
//    }
//}
    private fun setSlideList() {
        menuList.add(
            Service(
                R.drawable.img_pizza,
                "Restaurant",
                1
            )
        )
        menuList.add(
            Service(
                R.drawable.img_pizza,
                "Salle De Sport",
                2
            )
        )
        menuList.add(
            Service(
                R.drawable.img_pizza,
                "Restaurant",
                1
            )
        )
        menuList.add(
            Service(
                R.drawable.img_pizza,
                "Salle De Sport ",
                2
            )
        )
        menuList.add(
            Service(
                R.drawable.img_pizza,
                "Salle De Sport ",
                2
            )
        )
    }

    private fun getMealInformationFromIntent() {
        val args = this.arguments
        query = args?.get("query").toString()
    }
}