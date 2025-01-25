package com.sozge.animalquest.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sozge.animalquest.datas.UserDataUiEvents
import com.sozge.animalquest.datas.UserInputScreenState

class userInputViewModel : ViewModel() {
    companion object {
        const val TAG = "userInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun resetState() {
        uiState.value = UserInputScreenState()
    }

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = event.animal)
            }
        }
    }
}