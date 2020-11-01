package com.mindorks.example.jetpack.compose.button

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MaterialButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                SimpleTextComponent("Example of Simple Button")
                SimpleButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Text Button")
                TextButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Rounded Corners Button")
                RoundedCornerButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Bordered Button")
                BorderButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Button with Icon")
                ButtonWithIconComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Colored Button")
                ColoredButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Disabled Button")
                DisabledButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Outlined Button")
                OutlinedButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Icon Button")
                IconButtonComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Floating Action Button")
                FloatingActionButtonComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}

@Composable
fun SimpleButtonComponent() {
    val context = ContextAmbient.current
    // Button is a Composable that is used to make Button.
    // onClick will handle the click event of the button
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

@Composable
fun TextButtonComponent() {
    val context = ContextAmbient.current
    TextButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

@Composable
fun RoundedCornerButtonComponent() {
    val context = ContextAmbient.current
    // shape is used to give the shape to Compose UI elements.
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text("Click Me")
    }
}

@Composable
fun BorderButtonComponent() {
    val context = ContextAmbient.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
    ) {
        Text("Click Me")
    }
}

@Composable
fun ButtonWithIconComponent() {
    val context = ContextAmbient.current
    // You can put some icon on the Button by using Icon Composable.
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
    ) {
        Text("Click Me")
        Icon(Icons.Filled.Favorite)
    }
}

@Composable
fun ColoredButtonComponent() {
    val context = ContextAmbient.current
    Button(
        onClick = {
            Toast.makeText(context, "You clicked me :(", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        backgroundColor = Color.Red
    ) {
        Text("Don't Click Me")
        Icon(Icons.Filled.Favorite)
    }
}

@Composable
fun DisabledButtonComponent() {
    val context = ContextAmbient.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        enabled = false
    ) {
        Text("Click Me")
        Icon(Icons.Filled.Favorite)
    }
}

@Composable
fun OutlinedButtonComponent() {
    val context = ContextAmbient.current
    // OutlinedButton is used for actions that are important but are not the primary action
    // in the app. For example, in Google Play Store, Uninstall is an important action but
    // not the primary action of the Play Store.
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
    ) {
        Text("Click Me")
        Icon(Icons.Filled.Favorite)
    }
}

@Composable
fun IconButtonComponent() {
    val context = ContextAmbient.current
    // Icons can also be used as a button by using the IconButton composable.
    IconButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
    ) {
        Icon(Icons.Filled.Favorite)
    }
}

@Composable
fun FloatingActionButtonComponent() {
    val context = ContextAmbient.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(Icons.Filled.Favorite)
    }
}