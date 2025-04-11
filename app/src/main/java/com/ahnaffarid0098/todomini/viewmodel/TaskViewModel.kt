package com.ahnaffarid0098.todomini.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ahnaffarid0098.todomini.model.Task

class TaskViewModel : ViewModel() {
    private var nextId = 1
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    fun addTask(title: String, description: String) {
        val newTask = Task(id = nextId++, title = title, description = description)
        _tasks.add(newTask)
    }

    fun deleteTask(task: Task) {
        _tasks.remove(task)
    }

    fun toggleDone(task: Task) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            val updated = task.copy(isDone = !task.isDone)
            _tasks[index] = updated
        }
    }

    fun updateTask(id: Int, title: String, description: String) {
        val index = _tasks.indexOfFirst { it.id == id }
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(title = title, description = description)
        }
    }

    fun getTaskById(id: Int): Task? {
        return _tasks.find { it.id == id }
    }
}
