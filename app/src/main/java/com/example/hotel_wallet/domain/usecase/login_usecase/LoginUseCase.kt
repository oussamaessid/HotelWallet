package com.example.hotel_wallet.domain.usecase.login_usecase


import com.example.hotel_wallet.domain.repository.LoginRepository
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.data.model.UserListResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(
        userName: String,
        password: String
    ): Flow<Resource<UserListResponse>> {
        return repository.getLogin(userName, password)
    }
}