package com.example.taskmanagerapp.data

import com.example.taskmanagerapp.R
import com.example.taskmanagerapp.model.Task

class DataSource() {
    fun loadTasks(): List<Task> {
        return listOf<Task>(
            Task(R.string.Task1),
            Task(R.string.Task2),
            Task(R.string.Task3))
    }
}