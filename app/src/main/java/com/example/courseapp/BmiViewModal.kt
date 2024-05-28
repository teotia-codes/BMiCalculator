package com.example.courseapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
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
                    isHeightValueActive = HeightValueStage.ACTIVE,
                    isWeightValueActive = WeightValueStage.INACTIVE
                )
            }
            UserAction.WeightClicked ->{
                state = state.copy(
                    isWeightValueActive = WeightValueStage.INACTIVE,
                    isHeightValueActive = HeightValueStage.ACTIVE
                )
            }
        }
    }
    private fun enterNumber(number: String){
when {
    state.weightValueStage == WeightValueStage.ACTIVE -> {
        state = state.copy(
            weightValue =  if (number == ".") "0." else number,
            weightValueStage = WeightValueStage.RUNNING
        )

    }
    state.weightValueStage == WeightValueStage.RUNNING -> {
        state = state.copy(
            weightValue = state.weightValue + number ,
            weightValueStage =  WeightValueStage.RUNNING
        )

    }
    state.heightValueStage == HeightValueStage.ACTIVE -> {
        state = state.copy(
            heightValue =  if (number == ".") "0." else number,
            heightValueStage = HeightValueStage.RUNNING
        )

    }
    state.heightValueStage == HeightValueStage.RUNNING -> {
        state = state.copy(
            heightValue = state.heightValue + number ,
            heightValueStage =  HeightValueStage.RUNNING
        )
    }
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