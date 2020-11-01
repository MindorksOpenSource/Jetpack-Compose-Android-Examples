package com.mindorks.example.jetpack.compose.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.mindorks.example.jetpack.compose.R

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = "This is a Simple Image"
                )
                SimpleImageComponent()
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = "This is an image with rounded corners"
                )
                RoundedImageComponent()
            }
        }
    }
}

@Composable
fun SimpleImageComponent() {
    // Image is a composable that is used to display some image.
    val image = imageResource(R.drawable.mindorks_cover)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(image)
    }
}

@Composable
fun RoundedImageComponent() {
    val image = imageResource(R.drawable.mindorks_cover)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // contentScale is used to find the scaling aspect ratio
        Image(
            image,
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
    }
}