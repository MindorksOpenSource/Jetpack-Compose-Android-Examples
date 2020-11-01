package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.ToggleableState
import androidx.compose.material.Checkbox
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MaterialCheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleTextComponent(text = "Simple CheckBox Example")
                SimpleCheckboxComponent()
                SimpleTextComponent(text = "Colored CheckBox Example")
                ColoredCheckboxComponent()
                SimpleTextComponent(text = "Tri-State CheckBox Example")
                TriStateCheckboxComponent()
            }
        }
    }
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp
        ), modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}

@Composable
fun SimpleCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        // Checkbox is a Composable that is used to indicate two states. You can either
        // select or unselect the Checkbox. Checkboxes are generally used when we have
        // a number of options to choose from.

        // checked is used to identify or set if the checkbox is checked or not
        // onCheckedChange is called when there is a change in the checkbox
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
        )
        Text(text = "Checkbox Example", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ColoredCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        Checkbox(
            // You can change the color of the Checkbox(unchecked and checked sate)
            // by using uncheckedColor and checkedColor
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
            uncheckedColor = Color.Blue,
            checkedColor = Color.Green
        )
        Text(text = "Checkbox Example with color", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TriStateCheckboxComponent() {
    // Instead of having two states in the Checkbox, we can use three state i.e. checked,
    // unchecked and intermediate state. Intermediate state can be used when the user is
    // not sure about something and he/she can opt-in or opt-out some service.
    val toggleableState =
        listOf(ToggleableState.Off, ToggleableState.On, ToggleableState.Indeterminate)
    var counter by remember { mutableStateOf(0) }
    Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        TriStateCheckbox(
            state = toggleableState[counter % 3],
            onClick = {
                counter++
            })
        Text(text = "Checkbox tri-state example", modifier = Modifier.padding(start = 16.dp))
    }
}