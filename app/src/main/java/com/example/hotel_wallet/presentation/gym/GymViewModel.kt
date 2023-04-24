package com.example.hotel_wallet.presentation.gym


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel_wallet.domain.model.Gym
import com.example.hotel_wallet.domain.usecase.gym_usecase.GetGymUseCase
import com.example.hotel_wallet.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GymViewModel @Inject constructor(
    private val getGymUseCase: GetGymUseCase,
) : ViewModel() {

    private val _stateCategories = MutableLiveData<Resource<List<Gym>>>()
    val stateCategories: LiveData<Resource<List<Gym>>> get() = _stateCategories

    fun getCategories(category: String) {
        viewModelScope.launch {
            getGymUseCase(category)
                .onEach {
                    _stateCategories.value = it
                }.launchIn(viewModelScope)
        }
    }

}