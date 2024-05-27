package com.example.courseapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModal: ViewModel(){
    var state by mutableStateOf(BMIState())
    fun onAction(userAction: UserAction){
        when(userAction){
            UserAction.WeightValueClicked->{
                state = state.copy(
                    sheetTitle = "Weight",
                    sheetItemList = listOf("Kilogram", "Pounds")
                )
            }
            UserAction.HeighValueClicked->{
                state = state.copy(
                    sheetTitle = "Height",
                    sheetItemList = listOf("Centimetres", "metres", "Feet", "Inches")
                )
            }
            is UserAction.OnSheetItemClicked -> {
                changeWeightOrHeightUnit(userAction.sheetItem)
            }

            is UserAction.OnNumberClicked -> {
                enterNumber(userAction.number )

            }
            UserAction.HeightClicked ->{
                state = state.copy(
                    isHeightValueActive = true,
                    isWeightValueActive = false
                )
            }
            UserAction.WeightClicked ->{
                state = state.copy(
                    isWeightValueActive = false,
                    isHeightValueActive = false
                )
            }
        }
    }
    private fun enterNumber(number: String){
        if (state.isWeightValueActive){
            state = state.copy(weightValue = number)
        }
        else if(state.isHeightValueActive){
            state = state.copy(heightValue = number)
        }

    }
    private fun changeWeightOrHeightUnit(sheetItem: String){
        if (state.sheetTitle == "Weight"){
            state = state.copy(weightUnit = sheetItem)
        }
        else if (state.sheetTitle == "Height"){
            state= state.copy(heightUnit = sheetItem)
        }
    }
}

sealed class UserAction {
    object WeightValueClicked: UserAction()
    object  HeighValueClicked: UserAction()
    object HeightClicked: UserAction()
    object WeightClicked: UserAction()
    data class OnSheetItemClicked(val sheetItem: String): UserAction()
    data class OnNumberClicked(val number: String): UserAction()
}