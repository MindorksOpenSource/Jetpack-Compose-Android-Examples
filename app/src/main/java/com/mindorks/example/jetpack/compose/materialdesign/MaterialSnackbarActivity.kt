package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

class MaterialSnackbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleTextComponent(text = "Simple Snackbar Example")
                SimpleSnackbarComponent()
                SimpleTextComponent(text = "Action Snackbar Example")
                ActionSnackbarComponent()
            }
        }
    }
}

@Composable
fun SimpleSnackbarComponent() {
    // A Snackbar is a composable that is used to show some information at
    // the bottom of the screen. It is drawn over all the UI elements present on the screen.
    // Some example of information may be when you deleted something, or when you
    // downloaded something.
    Snackbar(
        modifier = Modifier.padding(16.dp),
        text = {
            Text(text = "I'm a Simple Snackbar")
        }
    )
}

@Composable
fun ActionSnackbarComponent() {
    // You can add some action on a Snackbar and on click of that action element,
    // some operation will be performed(most probably click action to dismiss Snackbar)
    Snackbar(
        modifier = Modifier.padding(16.dp),
        text = {
            Text(text = "I'm a Snackbar with Action")
        }, action = {
            Text(text = "OK", style = TextStyle(color = Color.Green))
        }
    )
}