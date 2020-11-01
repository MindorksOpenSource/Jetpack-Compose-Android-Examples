package com.mindorks.example.jetpack.compose.preview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
import androidx.ui.tooling.preview.PreviewParameter
import com.mindorks.example.jetpack.compose.data.Blog

class PreviewParameterActivity : AppCompatActivity() {
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

// This is an example of PreviewParameter. When your Composable function is
// taking such data that is not available right now(for example, data coming
// from server), then you need to pass dummy data to see the preview.
// So, here you can use the @PreviewParameter annotation
@Preview
@Composable
fun BlogInfo(@PreviewParameter(DummyBlogProvider::class) blog: Blog) {
    SimpleTextComponent("${blog.name} by ${blog.author}")
}