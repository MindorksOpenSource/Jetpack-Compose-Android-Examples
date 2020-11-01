package com.mindorks.example.jetpack.compose.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomViewComponent()
        }
    }
}

@Composable
fun CustomViewComponent() {
    // In Android, Canvas is used for 2D drawing on the screen. You can draw any
    // shape on your Canvas for example, Rectangle, Square, Circle etc.
    Canvas(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // drawRect is used to draw a rectangle
        drawRect(
            color = Color.Red,
            // topLeft is the coordinate of top-left point
            topLeft = Offset(0f, 0f),
            size = Size(800f, 400f)
        )
        drawRect(
            color = Color.Green,
            topLeft = Offset(100f, 100f),
            size = Size(600f, 200f)
        )
        drawRect(
            color = Color.Yellow,
            topLeft = Offset(200f, 150f),
            size = Size(400f, 100f)
        )
        // drawArc is used to draw an arc with some angle
        drawArc(
            Color.Gray,
            startAngle = 0f,
            sweepAngle = 120f,
            useCenter = true,
            size = Size(600f, 600f),
            topLeft = Offset(300f, 300f)
        )
        // drawLine is used to draw a line with start and end point
        drawLine(
            color = Color.Green,
            start = Offset(400f, 400f),
            end = Offset(500f, 500f),
            strokeWidth = 4f
        )
        // drawCircle is used to draw a circle
        drawCircle(
            color = Color.Red,
            center = Offset(500f, 500f),
            radius = 40f
        )
    }
}