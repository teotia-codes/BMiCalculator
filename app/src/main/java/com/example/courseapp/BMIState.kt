package com.example.courseapp

data class BMIState(
    val sheetTitle: String =  "",
    val sheetItemList: List<String> = emptyList(),
    val weightUnit: String = "Kilogram",
    val heightUnit: String = "Centimeter",
    val weightValue: String = "60",
    val heightValue: String = "170",
    val isHeightValueActive: Boolean = true,
    val isWeightValueActive: Boolean = false,
)
