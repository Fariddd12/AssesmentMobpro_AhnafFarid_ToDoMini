package com.ahnaffarid0098.todomini.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ahnaffarid0098.todomini.viewmodel.TaskViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun TaskListScreen(
    navController: NavController,
    taskViewModel: TaskViewModel = viewModel()
) {
    val tasks = taskViewModel.tasks.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add_edit_task")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Tambah")
            }
        }
    ) { padding ->
        if (tasks.isEmpty()) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Belum ada tugas.")
            }
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(tasks) { task ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (task.isDone) MaterialTheme.colorScheme.secondaryContainer
                            else MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = if (task.isDone) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row {
                                Button(
                                    onClick = { taskViewModel.toggleDone(task.id) }
                                ) {
                                    Text(if (task.isDone) "Batalkan" else "Selesai")
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(
                                    onClick = { taskViewModel.deleteTask(task.id) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.error
                                    )
                                ) {
                                    Text("Hapus")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TaskItem(title: String, isDone: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)
        Text(text = if (isDone) "✓" else "")
    }
}
