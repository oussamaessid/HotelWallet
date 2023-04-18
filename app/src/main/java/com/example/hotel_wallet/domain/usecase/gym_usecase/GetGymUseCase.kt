package com.example.hotel_wallet.domain.usecase.gym_usecase

import com.example.hotel_wallet.domain.model.Gym
import com.example.hotel_wallet.domain.model.GymRepository
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGymUseCase @Inject constructor(
    private val repository: GymRepository
) {
    suspend operator fun invoke(category: String): Flow<Resource<List<Gym>>> =
        repository.getGym(category)
}