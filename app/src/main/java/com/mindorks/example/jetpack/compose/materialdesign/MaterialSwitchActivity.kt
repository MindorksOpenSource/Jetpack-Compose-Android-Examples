package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MaterialSwitchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleTextComponent(text = "Simple Switch Example")
                SimpleSwitchComponent()
            }
        }
    }
}

@Composable
fun SimpleSwitchComponent() {
    val checkedState = remember { mutableStateOf(true) }
    // A Switch is a composable that is used to select/unselect between two options only.
    // For example, Switch can be used to enable or disable dark mode.
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}