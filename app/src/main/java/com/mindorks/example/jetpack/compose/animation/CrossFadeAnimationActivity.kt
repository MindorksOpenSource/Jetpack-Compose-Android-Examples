package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CrossFadeAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrossFadeAnimation(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun CrossFadeAnimation(
    modifier: Modifier
) {
    val languages = listOf("Java","Python","JavaScript", "C#", "C++", "PHP", "Ruby", "Swift", "Objective-C", "Kotlin", "Go",
        "Scala", "Rust", "TypeScript", "Dart", "Assembly", "Perl", "Visual Basic")

    var current by remember {
        mutableStateOf(languages.first())
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Crossfade(
            current = current,
            animation = tween(
                durationMillis = 400,
                delayMillis = 100,
                easing = LinearOutSlowInEasing
            )
        ) { currentStr ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = currentStr,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color(0xFFD32F2F),
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            backgroundColor = Color(0xFF00796B),
            onClick = {
                current = languages.random()
            }
        ){
            Text(
                text = "Click Here",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}