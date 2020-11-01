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
import com.mindorks.example.jetpack.compose.button.MaterialButtonActivity
import com.mindorks.example.jetpack.compose.layout.*
import com.mindorks.example.jetpack.compose.preview.PreviewParameterActivity
import com.mindorks.example.jetpack.compose.preview.SimplePreviewActivity
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
                ButtonComponent(
                    context = context,
                    intent = Intent(context, SimplePreviewActivity::class.java),
                    buttonText = "Simple Preview"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, PreviewParameterActivity::class.java),
                    buttonText = "Preview Parameter"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ColumnActivity::class.java),
                    buttonText = "Simple Column"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ScrollableColumnActivity::class.java),
                    buttonText = "Scrollable Column"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, LazyColumnActivity::class.java),
                    buttonText = "Lazy Column"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, RowActivity::class.java),
                    buttonText = "Row"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ScrollableRowActivity::class.java),
                    buttonText = "Scrollable Row"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, BoxActivity::class.java),
                    buttonText = "Box"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, StackActivity::class.java),
                    buttonText = "Stack (Deprecated)"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ConstraintLayoutActivity::class.java),
                    buttonText = "Constraint Layout"
                )
                Divider(color = Color.Black)
                ButtonComponent(
                    context = context,
                    intent = Intent(context, MaterialButtonActivity::class.java),
                    buttonText = "Button"
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
            context.startActivity(intent)
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