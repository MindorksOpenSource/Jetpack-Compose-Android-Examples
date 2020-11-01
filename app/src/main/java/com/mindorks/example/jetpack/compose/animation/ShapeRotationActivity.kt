package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class ShapeRotationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotatingComponent()
        }
    }
}

private val rotation = FloatPropKey()
private const val INITIAL = "INITIAL"
private const val FINAL = "FINAL"

// This function is used to define the transition. Here the initial angle of the square is 0
// and final is 360. We are performing the rotation animation in 6 seconds and this animation
// is repeatable. Also, you can change the animation easing according to your need.
private val rotationTransitionDefinition = transitionDefinition<String> {
    state(INITIAL) { this[rotation] = 0f }
    state(FINAL) { this[rotation] = 360f }
    transition(fromState = INITIAL, toState = FINAL) {
        rotation using repeatable(
            animation = tween(
                durationMillis = 6000,
                easing = FastOutSlowInEasing
            ),
            iterations = AnimationConstants.Infinite
        )
    }
}

@Composable
fun RotatingComponent() {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        children = {
            val state = transition(
                definition = rotationTransitionDefinition,
                initState = INITIAL,
                toState = FINAL
            )
            // Here we are drawing a square over a Canvas and then we are rotating the canvas
            Canvas(modifier = Modifier.preferredSize(200.dp)) {
                rotate(state[rotation]) {
                    drawRect(color = Color.Red)
                }
            }
        }
    )
}