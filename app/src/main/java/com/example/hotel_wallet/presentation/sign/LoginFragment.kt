package com.example.hotel_wallet.presentation.sign

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentLoginBinding
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.presentation.misc.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
), View.OnClickListener {

    private val loginViewModel by activityViewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            loginViewModel.stateLogin.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {

                        Toast.makeText(requireContext(), "the user is  login", Toast.LENGTH_LONG)
                            .show()
                        val sharedPreferences =
                            requireActivity().getSharedPreferences(
                                "authToken",
                                Context.MODE_PRIVATE
                            )
                        val editor = sharedPreferences.edit()
                        editor.putString("authToken", it.data.access_token)
                        editor.apply()
                        Log.i("token", it.data.access_token)
                        Log.i(
                            "toked stored",
                            sharedPreferences.getString("authToken", null).toString()
                        )
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                    }
                    is Resource.Error -> {
                        Toast.makeText(
                            requireContext(),
                            "the user is failed to login",
                            Toast.LENGTH_LONG
                        ).show()


                    }
                }
            }

        }

        binding.btnLogin.setOnClickListener(this)

    }

    private fun login(email: String, password: String) {
        loginViewModel.getLogin(email = email, password = password)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {
                if (binding.editEmail.text.trim().isNotBlank() &&
                    binding.editPassword.text.trim().isNotBlank()
                ) {
                    login(binding.editEmail.text.toString(), binding.editPassword.text.toString())
                }
            }
        }
    }
}


