package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MaterialProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleTextComponent(text = "Simple Circular Progress")
                SimpleCircularProgressComponent()
                SimpleTextComponent(text = "Circular ProgressBar with 40% progress")
                CircularProgressComponent()
                SimpleTextComponent(text = "Simple Linear Progress")
                SimpleLinearProgressComponent()
                SimpleTextComponent(text = "Linear Progress with 70% progress")
                LinearProgressComponent()
            }
        }
    }
}

@Composable
fun SimpleCircularProgressComponent() {
    // CircularProgressIndicator is generally used at the loading screen and it indicates that
    // some progress is going on so please wait.
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CircularProgressComponent() {
    // We can set the progress of a CircularProgressIndicator by using progress.
    // For example, if you are showing CircularProgressIndicator while downloading something
    // then you can show the download percent on the progress bar.
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp),
        progress = 0.4f,
        color = Color.Green
    )
}

@Composable
fun SimpleLinearProgressComponent() {
    // LinearProgressIndicator works similar to that of Circular Progress. The only difference
    // is that instead of circle, it is linear.
    LinearProgressIndicator(
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}

@Composable
fun LinearProgressComponent() {
    // Just like CircularProgressIndicator, we can set some progress to LinearProgressIndicator also.
    LinearProgressIndicator(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        progress = 0.7f,
        color = Color.Green
    )
}
