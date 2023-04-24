package com.example.hotel_wallet.presentation.sign

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel_wallet.data.model.MessageDto
import com.example.hotel_wallet.data.model.UserListResponse
import com.example.hotel_wallet.domain.usecase.login_usecase.LoginUseCase
import com.example.hotel_wallet.domain.usecase.login_usecase.SignUpUseCase
import com.example.hotel_wallet.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val signUpUseCase: SignUpUseCase,

    ) : ViewModel() {

    private val _stateLogin = MutableLiveData<Resource<UserListResponse>>()
    val stateLogin: LiveData<Resource<UserListResponse>> get() = _stateLogin

    private val _stateSignUp = MutableLiveData<Resource<MessageDto>>()
    val stateSignUp: LiveData<Resource<MessageDto>> get() = _stateSignUp

    fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password)
                .onEach {
                    _stateLogin.value = it
                }.launchIn(viewModelScope)
        }
    }

    fun signUp(
        name: String,
        email: String,
        password: String

    ) {
        viewModelScope.launch {
            signUpUseCase(
                name,
                email,
                password
            )
                .onEach {
                    _stateSignUp.value = it
                }.launchIn(viewModelScope)
        }
    }
}