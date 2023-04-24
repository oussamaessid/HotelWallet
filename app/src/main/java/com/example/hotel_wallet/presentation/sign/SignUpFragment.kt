package com.example.hotel_wallet.presentation.sign

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hotel_wallet.R
import com.example.hotel_wallet.databinding.FragmentSignUpBinding
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.presentation.misc.BaseFragment
import com.google.android.material.snackbar.Snackbar


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(
    FragmentSignUpBinding::inflate
), View.OnClickListener {

    private val loginViewModel by activityViewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            loginViewModel.stateSignUp.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        Snackbar.make(view, it.data.message, Snackbar.LENGTH_LONG).show()
                        Toast.makeText(requireContext(), "the user is register", Toast.LENGTH_LONG)
                            .show()
                        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)

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

        binding.btnRegister.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)

    }

    private fun signUp(
        name: String,
        email: String,
        password: String
    ) {

        loginViewModel.signUp(name, email, password)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_register -> {
                if (binding.editName.text.trim().isNotBlank() &&
                    binding.editEmail.text.trim().isNotBlank() &&
                    binding.editPassword.text.trim().isNotBlank()
                ) {
                    signUp(
                        binding.editName.text.toString(),
                        binding.editEmail.text.toString(),
                        binding.editPassword.text.toString()
                    )
                    Log.println(Log.ASSERT, "name", binding.editName.text.toString())
                    Log.println(Log.ASSERT, "email", binding.editEmail.text.toString())
                    Log.println(Log.ASSERT, "password", binding.editPassword.text.toString())
                }
            }
            R.id.btn_login -> {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }

}