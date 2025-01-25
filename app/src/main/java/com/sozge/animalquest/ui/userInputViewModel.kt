package com.sozge.animalquest.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sozge.animalquest.ui.screens.UserDataUiEvents
import com.sozge.animalquest.ui.screens.UserInputScreenState

class userInputViewModel: ViewModel() {

    companion object {
        const val TAG = "userInputViewModel"
    }




        var uiState = mutableStateOf(UserInputScreenState())


    fun resetState() {
        uiState.value = UserInputScreenState()
    }

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

    fun isValidState() : Boolean {
        if( !uiState.value.nameEntered.isNullOrEmpty()
            &&
            !uiState.value.animalSelected.isNullOrEmpty()) {
            return true
        }else {
            return false
        }

    }


}

val animalFacts = mapOf(
    "Cat" to listOf(
        "Cats sleep 12–16 hours a day.",
        "Cats can rotate their ears 180 degrees.",
        "A group of cats is called a clowder."
    ),
    "Dog" to listOf(
        "Dogs have a sense of time and miss you when you’re gone.",
        "Dogs can learn more than 1000 words.",
        "A dog’s nose print is unique, like a human fingerprint."
    )
)





