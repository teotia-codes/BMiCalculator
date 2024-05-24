package com.example.courseapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnitItem(
    text: String,
    onClick: () -> Unit,
    color: Color
) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,
            color = color,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium)
        Icon(imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Select Icon")
    }
}

@Composable
fun NumberB(
    value : String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(10.dp)
            .clip(CircleShape)
            .clickable { onClick(value) }
    ){
        Text(text = value,
            color = Color.White,
            fontSize = 40.sp)

    }

}

@Composable
fun InputUnitValue(
    inputValue: String,
    inputUnit: String,
    inputColor: Color,
    onUnitValueClicked: () ->Unit
) {
    Column(
        modifier = Modifier.background(color = Color.Transparent),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = inputValue,
            fontSize = 40.sp,
            color = inputColor,
            modifier = Modifier.clickable {
                onUnitValueClicked()
            })
        Text(text = inputUnit,
            color = inputColor,
            fontSize = 12.sp)
    }
}


@Composable
fun NumberKeyboard() {
    Column(modifier = Modifier) {
        val numberList = listOf(
            "7", "8", "9", "4", "5", "6", "1", "2", "3","", "0", "."
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(numberList) { item ->
                NumberB(
                    value = item,
                    onClick = {},
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }

        }
    }
}

@Preview
@Composable
fun PRevv() {
    NumberKeyboard()
}


