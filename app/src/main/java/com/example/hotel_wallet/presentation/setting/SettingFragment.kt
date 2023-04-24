package com.example.hotel_wallet.presentation.setting

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentSettingBinding
import com.example.hotel_wallet.presentation.misc.BaseFragment


class SettingFragment : BaseFragment<FragmentSettingBinding>(
    FragmentSettingBinding::inflate
), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardViewProfile.setOnClickListener(this)
        binding.cardViewLanguage.setOnClickListener(this)

        binding.customToolbar.txtTitle.text = "Setting"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.cardViewProfile -> {
                findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
            }
            R.id.cardViewLanguage -> {
                findNavController().navigate(R.id.action_settingFragment_to_languageFragment)
            }
        }
    }

}
