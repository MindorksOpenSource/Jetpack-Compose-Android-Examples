package com.mindorks.example.jetpack.compose.layout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.example.jetpack.compose.data.Blog
import com.mindorks.example.jetpack.compose.data.getBlogList

class ScrollableColumnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumnComponent(blogList = getBlogList())
        }
    }
}

@Composable
fun ScrollableColumnComponent(blogList: List<Blog>) {
    // ScrollableColumn is a composable that is used to keep all its children in vertical orientation
    // and at the same time it is scrollable also i.e. when the content will cover the whole screen,
    // then you can scroll down and see other contents. It behaves similar to vertical ScrollView.
    ScrollableColumn {
        val context = ContextAmbient.current
        Column {
            for (blog in blogList) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.fillMaxWidth().padding(16.dp).clickable(onClick = {
                        Toast.makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT).show()
                    }),
                    backgroundColor = Color(0xFFFFA867.toInt())
                ) {
                    Text(
                        blog.name, style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}