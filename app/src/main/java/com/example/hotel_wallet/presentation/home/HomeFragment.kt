package com.example.hotel_wallet.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentHomeBinding
import com.example.hotel_wallet.domain.model.Service
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hotel_wallet.presentation.misc.BaseFragment
import com.example.hotel_wallet.utility.CATEGORY_EAT
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private lateinit var homeAdapter: HomeAdapter
    private var menuList = mutableListOf<Service>()
    val imageList = ArrayList<SlideModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        val bottomNavigation =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = Navigation.findNavController(requireActivity(), R.id.fragment)

        NavigationUI.setupWithNavController(bottomNavigation, navController)


        homeAdapter = HomeAdapter(menuList) { type ->
            if (type.type == CATEGORY_EAT) {
//                findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
            } else {
//                findNavController().navigate(R.id.action_homeFragment_to_gymFragment)

            }
        }
        binding.customToolbar.imgNotification.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        setSlideList()
        binding.recyclerViewHome.setHasFixedSize(true)
        binding.recyclerViewHome.isNestedScrollingEnabled = false
        binding.recyclerViewHome.adapter = homeAdapter

        imageList.clear()
        imageList.add(SlideModel(R.drawable.img_hotel1, "Amir Palace"))
        imageList.add(SlideModel(R.drawable.img_hotel2, "Amir Palace"))
        imageList.add(SlideModel(R.drawable.img_hotel3, "Amir Palace"))
        imageList.add(SlideModel(R.drawable.img_hotel4, "Amir Palace"))
        imageList.add(SlideModel(R.drawable.img_hotel5, "Amir Palace"))

        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                filterList(query)
                val bundle = Bundle()
                bundle.putString("query", query)
//                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
//                filterList(newText)
                return false
            }
        })

    }



    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Service>()
            for (i in menuList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                homeAdapter.setFilteredList(filteredList)
            }
        }
    }

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

}