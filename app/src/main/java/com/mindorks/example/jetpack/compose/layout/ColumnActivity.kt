package com.mindorks.example.jetpack.compose.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class ColumnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleColumnComponent()
        }
    }
}

@Composable
fun SimpleColumnComponent() {
    // Column is used to keep the child vertically.
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Hello! I am Text 1", color = Color.Black)
        Text(text = "Hello! I am Text 2", color = Color.Blue)
        Text(text = "Hello! I am Text 3", color = Color.Red)
        Text(text = "Hello! I am Text 4", color = Color.Green)
    }
}