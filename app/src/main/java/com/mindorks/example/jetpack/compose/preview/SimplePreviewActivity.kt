package com.mindorks.example.jetpack.compose.preview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class SimplePreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleTextComponent("I am learning Preview. Please check the code for more understanding")
            }
        }
    }
}

@Composable
fun SimpleTextComponent(displayText: String) {
    // Text composable is used to display some text
    Text(text = displayText)
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
// To do so, you need to use @Preview annotation and then write a Composable function and call your UI element.
// The UI will be refreshed on every build or you can refresh manually from the UI preview tab.
@Preview
@Composable
fun SimpleTextPreview() {
    SimpleTextComponent("Hi I am learning Compose")
}

// By Default, the name of the preview is same as that of the function. But you can set the name
// by using name parameter
@Preview(name = "Named Preview")
@Composable
fun SimpleTextNamedPreview() {
    SimpleTextComponent("Hi I am learning Compose")
}