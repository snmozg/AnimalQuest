package com.sozge.animalquest.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sozge.animalquest.ui.screens.UserDataUiEvents
import com.sozge.animalquest.ui.screens.UserInputScreenState

class userInputViewModel: ViewModel() {

        var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = event.animal)
            }
        }
    }

}



