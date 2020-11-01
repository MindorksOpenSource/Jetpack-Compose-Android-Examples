package com.mindorks.example.jetpack.compose.data

data class Blog(
    val name: String,
    val author: String
)

fun getBlogList() = listOf(
    Blog("What is Android?", "MindOrks Admin"),
    Blog("What is LiveData?", "MindOrks Admin"),
    Blog("All about MVVM?", "Amit Shekhar"),
    Blog("Jetpack DataStore Preferences", "Amit Shekhar"),
    Blog("Text Styling", "Sumit Mishra"),
    Blog("In-App Review", "Himanshu Singh"),
    Blog("RecyclerView Multiple View", "Sumit Mishra"),
    Blog("RxJava", "Amit Shekhar"),
    Blog("Dagger", "Himanshu Singh"),
    Blog("PRDownloader", "Amit Shekhar"),
    Blog("Kotlin Coroutines", "Amit Shekhar"),
    Blog("Android Best Practices", "Amit Shekhar")
)