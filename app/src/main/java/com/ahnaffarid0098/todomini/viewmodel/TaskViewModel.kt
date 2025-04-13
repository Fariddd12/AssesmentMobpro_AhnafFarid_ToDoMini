package com.ahnaffarid0098.todomini.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.ahnaffarid0098.todomini.model.Task
import com.ahnaffarid0098.todomini.model.TaskDatabase
import com.ahnaffarid0098.todomini.model.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    val tasks: LiveData<List<Task>>

    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        tasks = repository.allTasks.asLiveData()
    }

    fun addTask(title: String, description: String) {
        val newTask = Task(title = title, description = description)
        viewModelScope.launch {
            repository.insert(newTask)
        }
    }

    fun toggleDone(task: Task) {
        viewModelScope.launch {
            repository.update(task.copy(isDone = !task.isDone))
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }
}
