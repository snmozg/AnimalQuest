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
    ),
    "Koala" to listOf(
        "Koalas are marsupials native to Australia and are known for their eucalyptus diet.",
        "They sleep up to 18–22 hours a day to conserve energy.",
        "Koalas have a unique vocalization, often described as a bellowing sound.",
        "Their fur acts as insulation, helping them adapt to different climates.",
        "Koalas are not bears; their closest relatives are wombats."
    ),
    "Fish" to listOf(
        "Fish have been on the earth for more than 450 million years.",
        "Fish have a lateral line system that helps them detect movement and vibration in the water.",
        "Fish have taste buds all over their bodies.",
        "Some species, like clownfish, form symbiotic relationships with sea anemones."
    ),
    "Hamster" to listOf(
        "Hamsters are rodents that belong to the subfamily Cricetinae.",
        "They are native to Europe and Asia.",
        "Hamsters are nocturnal animals, meaning they are most active at night.",
        "They have large cheek pouches that they use to carry food and bedding."
    ),
    "Cow" to listOf(
        "Cows have an acute sense of smell and can detect scents up to six miles away.",
        "Cows have a unique digestive system with four compartments in their stomach.",
        "Cows have a body temperature of about 101.5°F (38.6°C).",
        "Cows can sleep while standing up."
    ),
    "Monkey" to listOf(
        "Monkeys are primates that belong to the suborder Haplorhini.",
        "They are known for their intelligence and social behavior.",
        "Monkeys have opposable thumbs that help them grasp objects.",
        "Some species, like capuchin monkeys, use tools to obtain food."
    ),
    "Bear" to listOf(
        "Bears are mammals that belong to the family Ursidae.",
        "They are found in a variety of habitats, from forests to tundra.",
        "Bears have an excellent sense of smell, which helps them find food.",
        "Some species, like polar bears, are excellent swimmers."
    ),
    "Horse" to listOf(
        "Horses are herbivores that belong to the family Equidae.",
        "They have a strong sense of balance and coordination.",
        "Horses can sleep both lying down and standing up.",
        "They have a unique digestive system that relies on fermentation in the hindgut."
    ),


)





