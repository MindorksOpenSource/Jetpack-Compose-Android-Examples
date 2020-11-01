package com.mindorks.example.jetpack.compose.clickable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ClickableExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleButtonComponent()
                Divider(color = Color.Gray)
                SimpleTextComponent()
                Divider(color = Color.Gray)
                SimpleCardComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}

// clickable is used to receive click events from components and perform some action based on
// click event. It supports one click, double click, and long press.

@Composable
fun SimpleButtonComponent() {
    val context = ContextAmbient.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Button", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

@Composable
fun SimpleTextComponent() {
    val context = ContextAmbient.current
    Text(
        text = "Click Me",
        textAlign = TextAlign.Center,
        color = Color.Black,
        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Text", Toast.LENGTH_SHORT).show()
        }, onLongClick = {
            Toast.makeText(context, "Thanks for LONG click! I am Text", Toast.LENGTH_SHORT).show()
        }, onDoubleClick = {
            Toast.makeText(context, "Thanks for DOUBLE click! I am Text", Toast.LENGTH_SHORT).show()
        })
    )
}

@Composable
fun SimpleCardComponent() {
    val context = ContextAmbient.current
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color(0xFFFFA867.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Card.", Toast.LENGTH_SHORT).show()
        })
    ) {
        Text(
            text = "Click Me",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}