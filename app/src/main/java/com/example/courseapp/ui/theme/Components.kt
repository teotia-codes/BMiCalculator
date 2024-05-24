package com.example.courseapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapp.R

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
fun NumberKeyboard(
    modifier: Modifier,
    onNumberClicked: (String)->Unit
) {
    Column(modifier = modifier) {
        val numberList = listOf(
            "7", "8", "9", "4", "5", "6", "1", "2", "3","", "0", "."
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(numberList) { item ->
                NumberB(
                    value = item,
                    onClick = onNumberClicked,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }

        }
    }
}

@Composable
fun ColumnScope.SymbolButton(
    symbol: String,
    onClick: () ->Unit
) {
    Box(modifier = Modifier
        .padding(20.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(CustomGray)
        .clickable { onClick() }
        .padding(15.dp)
        .weight(1f)
        .aspectRatio(1f))
    {
        Text(text = symbol, fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = CustomOrange)
    }
}
@Composable
fun ColumnScope.SymbolButtonwithIcon(
    onClick: () ->Unit
) {
    Box(modifier = Modifier
        .padding(20.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(CustomGray)
        .clickable { onClick() }
        .padding(15.dp)
        .weight(1f)
        .aspectRatio(1f))
    {
        Icon(painter = painterResource(R.drawable.baseline_backspace_24),
            contentDescription = "Delete Icon",
            tint = CustomOrange,
            modifier = Modifier.size(40.dp))
     }
}

@Composable
fun BMIResultCard() {
    Column {
        Row {
            Text(text = "20.8", color = CustomOrange )
            Column {
                Text(text = "BMI", color = CustomGray , fontSize = 40.sp)
                Text(text = "Normal", color = CustomGray , fontSize = 18.sp )



            }

        }
    }
}

