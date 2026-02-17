package com.example.taskmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanagerapp.model.Tasks
import com.example.taskmanagerapp.ui.theme.TaskManagerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerAppTheme {

            }
        }
    }
}
//main app
@Composable
fun TaskManagerApp() {

}
//task list style
@Composable
fun TaskLine() {

}
//list item component
//@Composable
//fun TaskList(task: Tasks, modifier: Modifier = Modifier) {
//    Card(modifier = modifier) {
//        Column {
//            Text(
//                text = LocalContext.current.getString(Tasks.stringResourceId),
//                modifier = Modifier.padding(16.dp)
//            )
//        }
//    }
//}

//@Preview
//@Composable
//fun TaskListPreview() {
//    TaskList(Tasks(R.string.Task1))
//}