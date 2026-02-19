package com.example.taskmanagerapp

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanagerapp.data.DataSource
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
    val layoutDirection = LocalLayoutDirection.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        Text(
            text = stringResource(R.string.app_name)
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = stringResource(R.string.SearchBar)
            )
            Text(
                text = stringResource(R.string.PlaceHolder1)
            )
        }
        TaskList(
            taskList = DataSource().loadTasks(),
        )
    }
}
//task list style
@Composable
fun TaskLine(tasks: Tasks, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text(
                text = LocalContext.current.getString(tasks.stringResourceId),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
//list item component
@Composable
fun TaskList(taskList: List<Tasks>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(taskList) { tasks ->
            TaskLine(
                tasks = tasks,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
@Preview
@Composable
fun TaskManagerAppPreview() {
    TaskManagerApp()
}

//@Preview
//@Composable
//fun TaskListPreview() {
//    TaskList()
//}

//@Preview
//@Composable
//fun TaskLinePreview() {
//    Column {
//        TaskLine(Tasks(R.string.Task1))
//        TaskLine(Tasks(R.string.Task2))
//        TaskLine(Tasks(R.string.Task3))
//    }
//}