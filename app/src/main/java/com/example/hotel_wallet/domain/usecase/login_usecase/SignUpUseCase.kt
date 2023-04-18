package com.example.hotel_wallet.domain.usecase.login_usecase

import com.example.hotel_wallet.domain.repository.LoginRepository
import com.example.hotel_wallet.utility.Resource
import com.example.hotelwallet.data.model.MessageDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signRepository: LoginRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<MessageDto>> =
        signRepository.signUp(
            name,
            email,
            password
        )
}