package com.ahnaffarid0098.todomini.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahnaffarid0098.todomini.ui.screens.TaskListScreen
import com.ahnaffarid0098.todomini.ui.screens.AddEditTaskScreen
import com.ahnaffarid0098.todomini.ui.screens.AboutScreen
import com.ahnaffarid0098.todomini.viewmodel.TaskViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    taskViewModel: TaskViewModel
) {
    NavHost(navController = navController, startDestination = "task_list") {
        composable("task_list") {
            TaskListScreen(navController, taskViewModel)
        }
        composable("add_edit_task") {
            AddEditTaskScreen(navController, taskViewModel)
        }
        composable("about") {
            AboutScreen()
        }
    }
}
