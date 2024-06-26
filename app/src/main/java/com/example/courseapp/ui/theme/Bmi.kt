package com.example.courseapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.courseapp.BmiViewModal
import com.example.courseapp.UserAction
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BMIScreen(
    viewModel: BmiViewModal
) {
    val state = viewModel.state
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true)
    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetState = modalBottomSheetState,
        sheetContent = {
                                          BottomSheetContent(

                                              sheetTitle = state.sheetTitle,
                                              sheetItemList = state.sheetItemList,
                                              onItemCLick = {
                                                  coroutineScope.launch {
                                                      modalBottomSheetState.hide()
                                                  }
                                                  viewModel.onAction(UserAction.OnSheetItemClicked(sheetItem = it))
                                              },
                                              onCancelClick = {
                                                  coroutineScope.launch {
                                                      modalBottomSheetState.hide()
                                                  }
                                              }
                                          )

    },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold ,
                            text = "BMI ",
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            color = CustomOrange
                        )
                        Text(
                            fontWeight = FontWeight.Bold ,
                            text = "Calculator",
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        UnitItem(text = "Weight",
                            onClick = {
                                      coroutineScope.launch {
                                          modalBottomSheetState.show()
                                      }
                                viewModel.onAction(UserAction.WeightValueClicked)
                            },
                            color = Color.White)
                        InputUnitValue(inputValue = state.weightValue,
                            inputUnit = state.weightUnit,
                            inputColor = Color.White,
                            onUnitValueClicked = {
                               viewModel.onAction(UserAction.WeightClicked)
                            })
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        UnitItem(text = "Height",
                            onClick = {
                                coroutineScope.launch {
                                    modalBottomSheetState.show()
                                }
                                viewModel.onAction(UserAction.HeighValueClicked)

                            },
                            color = Color.White)
                        InputUnitValue(inputValue = state.heightValue,
                            inputUnit = state.heightUnit,
                            inputColor = Color.White,
                            onUnitValueClicked = {
                                viewModel.onAction(UserAction.HeightClicked)
                            })
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    Divider()
                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                         NumberKeyboard(
                            onNumberClicked = {
                                viewModel.onAction(UserAction.OnNumberClicked(it))
                            }, modifier = Modifier.weight(7f))
                        Column(
                            modifier = Modifier.weight(3f)
                        ) {
                            SymbolButton(symbol = "AC", onClick = {})
                            SymbolButtonwithIcon(onClick = {})
                            SymbolButton(symbol = "GO", onClick = {})
                        }
                    }

                }

            }

        })



}

@Preview
@Composable
fun BMIScreenPrev() {
}