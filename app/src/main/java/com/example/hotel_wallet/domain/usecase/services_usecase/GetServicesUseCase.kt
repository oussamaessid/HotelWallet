package com.example.hotel_wallet.domain.usecase.services_usecase

import com.example.hotel_wallet.domain.model.Services
import com.example.hotel_wallet.domain.repository.ServiceRepository
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val repository: ServiceRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Services>>> = repository.getServices()
}