package com.example.courseapp

data class BMIState(
    val sheetTitle: String =  "",
    val sheetItemList: List<String> = emptyList(),
    val weightUnit: String = "Kilogram",
    val heightUnit: String = "Centimeter"
)
