package com.mindorks.example.jetpack.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.mindorks.example.jetpack.compose.text.SimpleTextActivity
import com.mindorks.example.jetpack.compose.text.TextFieldActivity
import com.mindorks.example.jetpack.compose.text.TextStylingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                val context = ContextAmbient.current
                ButtonComponent(
                    context = context,
                    intent = Intent(context, SimpleTextActivity::class.java),
                    buttonText = "Simple Text"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextStylingActivity::class.java),
                    buttonText = "Text Styling"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextFieldActivity::class.java),
                    buttonText = "Text Field (EditText)"
                )
                Divider(color = Color.Black)
            }
        }
    }
}

@Composable
fun ButtonComponent(context: Context, intent: Intent, buttonText: String) {
    Button(
        onClick = {
            ContextCompat.startActivity(context, intent, bundleOf())
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Gray
    ) {
        Text(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            text = buttonText,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}