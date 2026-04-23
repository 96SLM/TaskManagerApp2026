package com.example.taskmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanagerapp.data.DataSource
import com.example.taskmanagerapp.model.Task
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
//    var taskInput : MutableState<String> = mutableStateOf("Task")
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
                .padding(horizontal = 8.dp)
        )
        {
            TaskInputField(
//                task = R.string.enterTask,
//                value = taskInput.value,
//                keyboardOptions = KeyboardOptions.Default,
//                conValueChange = {taskInput = it},
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = { /*ToDo: Add to list*/}) {
                Text(stringResource(R.string.PlaceHolder1))
            }
        }
        TaskList(
            taskList = DataSource().loadTasks(),
        )

    }
}
//Text field for task input
@Composable
fun TaskInputField(
//    @StringRes task: Int,
//    value: String,
//    keyboardOptions: KeyboardOptions,
//    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    var taskInput by remember { mutableStateOf(" ") }
    TextField(
        label = { Text(stringResource(R.string.enterTask)) },
        value = taskInput,
        singleLine = true,
        modifier = modifier,
        onValueChange = { taskInput = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

//task list style
@Composable
fun TaskLine(task: Task, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
            //.wrapContentWidth()
            horizontalArrangement = Arrangement.Center
        ){
            Checkbox(
                checked = false,
                onCheckedChange = {/*ToDo: task is completed, cross-out text but don't remove*/}
            )
            Text(
                text = LocalContext.current.getString(task.stringResourceId),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = modifier.width(16.dp))
            Button(onClick = { /*ToDo: delete from list*/}) {
                Text(stringResource(R.string.PlaceHolder3))
            }
        }
    }
}
//list item component
@Composable
fun TaskList(taskList: List<Task>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(taskList) { tasks ->
            TaskLine(
                task = tasks,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

/* Text Strikethrough code
* Text(
    text = "Strikethrough text",
    style = TextStyle(textDecoration = TextDecoration.LineThrough)
)
*/
@Preview
@Composable
fun TaskManagerAppPreview() {
    TaskManagerApp()
}

@Preview
@Composable
fun TaskListPreview() {
    TaskList(taskList = DataSource().loadTasks())
}

@Preview
@Composable
fun TaskLinePreview() {
    Column {
        TaskLine(Task(R.string.Task1))
//        TaskLine(Task(R.string.Task2))
//        TaskLine(Task(R.string.Task3))
    }
}