package com.ahnaffarid0098.todomini.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahnaffarid0098.todomini.ui.screens.TaskListScreen
import com.ahnaffarid0098.todomini.ui.screens.AddEditTaskScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "task_list") {
        composable("task_list") {
            TaskListScreen(navController)
        }
        composable("add_edit_task") {
            AddEditTaskScreen(navController)
        }
    }
}
