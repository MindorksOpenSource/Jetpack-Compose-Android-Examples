package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MaterialSliderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleTextComponent(text = "Simple Slider Example")
                SimpleSliderComponent()
                SimpleTextComponent(text = "Colored Slider Example")
                ColoredSliderComponent()
                SimpleTextComponent(text = "Stepped Slider Example")
                SteppedSliderComponent()
            }
        }
    }
}

@Composable
fun SimpleSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    // A Slider is a composable that is used to make selections from a range of values.
    // For example, Slider can be used to increase/decrease brightness or volume or anything
    // else that is having a range of values.
    // onValueChange is used to identify if there is some change in the Slider.
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun ColoredSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        },
        thumbColor = Color.Yellow,
        activeTrackColor = Color.Red,
        inactiveTrackColor = Color.Gray
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SteppedSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.5f) }
    // SteppedSliders are used to select from some discrete values only.
    // For example, in the below code, there are only 10 steps and the
    // user can slide in between these 10 steps only. This is helpful when
    // you have a number of options but the options are limited.
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        valueRange = 0f..10f,
        steps = 10,
        onValueChange = { sliderValue = it })
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}