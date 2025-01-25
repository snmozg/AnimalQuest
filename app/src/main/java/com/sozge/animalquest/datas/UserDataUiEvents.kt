package com.sozge.animalquest.datas

sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String): UserDataUiEvents()
    data class AnimalSelected(val animal: String): UserDataUiEvents()
}