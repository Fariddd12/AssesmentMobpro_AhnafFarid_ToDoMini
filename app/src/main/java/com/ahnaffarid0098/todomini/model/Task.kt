package com.ahnaffarid0098.todomini.model

data class Task(
    val id: Int,
    val title: String,
    val description: String = "",
    val isDone: Boolean = false
)
