package com.example.taskmanagerapp.data

import com.example.taskmanagerapp.R
import com.example.taskmanagerapp.model.Tasks

class DataSource() {
    fun loadTasks(): List<Tasks>{
        return listOf<Tasks>(
            Tasks(R.string.Task1),
            Tasks(R.string.Task2),
            Tasks(R.string.Task3)
        )
    }
}