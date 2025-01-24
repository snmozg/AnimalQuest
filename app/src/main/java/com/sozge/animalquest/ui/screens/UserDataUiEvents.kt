package com.sozge.animalquest.ui.screens

sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String): UserDataUiEvents()
    data class AnimalSelected(val animal: String): UserDataUiEvents()
}