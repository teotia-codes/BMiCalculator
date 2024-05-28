package com.example.courseapp

data class BMIState(
    val sheetTitle: String =  "",
    val sheetItemList: List<String> = emptyList(),
    val weightUnit: String = "Kilogram",
    val heightUnit: String = "Centimeter",
    val weightValue: String = "60",
    val heightValue: String = "170",
    val isHeightValueActive: HeightValueStage = true,
    val isWeightValueActive: WeightValueStage = false,
    val weightValueStage: WeightValueStage = WeightValueStage.ACTIVE,
    val heightValueStage: HeightValueStage = HeightValueStage.INACTIVE
)
enum class WeightValueStage{
    INACTIVE,
    ACTIVE,
    RUNNING
}
enum class HeightValueStage{
    INACTIVE,
    ACTIVE,
    RUNNING
}