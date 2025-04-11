package com.ahnaffarid0098.todomini

import androidx.activity.viewModels
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ahnaffarid0098.todomini.nav.AppNavGraph
import com.ahnaffarid0098.todomini.ui.theme.ToDoMiniTheme
import com.ahnaffarid0098.todomini.viewmodel.TaskViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val taskViewModel: TaskViewModel by viewModels()

        setContent {
            ToDoMiniTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController, taskViewModel = taskViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoMiniTheme {
        Greeting("Android")
    }
}