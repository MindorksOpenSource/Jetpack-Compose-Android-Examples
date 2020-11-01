package com.mindorks.example.jetpack.compose.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent

class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutComponent()
        }
    }
}

@Composable
fun ConstraintLayoutComponent() {
    // The ConstraintLayout is a Composable that is used to include the elements in a
    // ConstraintLayout that are constrained with respect to each other.
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // createRefs is used to tell which elements are going to be the part of
        // ConstraintLayout. Here, button, textTop, textBottom, textStart, and textEnd
        // are the part of ConstraintLayout
        val (button, textTop, textBottom, textStart, textEnd) = createRefs()
        Button(
            onClick = { /* Do something */ },
            // linkTo is used to connect some side of one element to some side of other element
            // constrainAs is used to tell on which element we are applying constrain in the
            // ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Button")
        }
        Text("Text Top", Modifier.constrainAs(textTop) {
            top.linkTo(parent.top)
            bottom.linkTo(button.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text("Text Bottom", Modifier.constrainAs(textBottom) {
            top.linkTo(button.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text("Text Start", Modifier.constrainAs(textStart) {
            start.linkTo(parent.start)
            end.linkTo(button.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Text("Text End", Modifier.constrainAs(textEnd) {
            start.linkTo(button.end)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
    }
}