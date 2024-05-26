package com.example.courseapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModal: ViewModel(){
    var state by mutableStateOf(BMIState())


}

sealed class UserAction {
    object WeightValueClicked: UserAction()
    object  HeighValueClicked: UserAction()
}