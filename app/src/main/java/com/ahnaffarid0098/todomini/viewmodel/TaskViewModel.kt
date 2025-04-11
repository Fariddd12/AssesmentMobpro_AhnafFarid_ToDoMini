package com.ahnaffarid0098.todomini.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ahnaffarid0098.todomini.model.Task

class TaskViewModel : ViewModel() {
    private var nextId = 1
    private val _tasks = mutableStateOf(listOf<Task>())
    val tasks: State<List<Task>> = _tasks

    fun addTask(title: String, description: String) {
        val newTask = Task(id = nextId++, title = title, description = description)
        _tasks.value = _tasks.value + newTask
    }

    fun deleteTask(taskId: Int) {
        _tasks.value = _tasks.value.filter { it.id != taskId }
    }

    fun toggleDone(taskId: Int) {
        val updated = _tasks.value.map {
            if (it.id == taskId) it.copy(isDone = !it.isDone) else it
        }
        _tasks.value = updated
    }

    fun updateTask(id: Int, title: String, description: String) {
        _tasks.value = _tasks.value.map {
            if (it.id == id) it.copy(title = title, description = description) else it
        }
    }

    fun getTaskById(id: Int): Task? {
        return _tasks.value.find { it.id == id }
    }
}
