package com.example.hotel_wallet.presentation.welcome

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentWelcomeBinding
import com.example.hotel_wallet.domain.model.WelcomeSlide
import com.example.hotel_wallet.presentation.misc.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(
    FragmentWelcomeBinding::inflate
), View.OnClickListener {

    private lateinit var slideAdapter: WelcomeOnBoardingAdapter
    private var slideList = mutableListOf<WelcomeSlide>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBottomNavigation(false)
        binding.btnEnglish.setOnClickListener(this)
        binding.btnArabic.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_english -> {
                findNavController().navigate(R.id.action_welcomeFragment_to_welcomeOnBoardingFragment)
            }
            R.id.btn_arabic -> {
                findNavController().navigate(R.id.action_welcomeFragment_to_welcomeOnBoardingFragment)
            }
        }
    }
}