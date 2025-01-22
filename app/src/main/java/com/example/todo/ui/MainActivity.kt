package com.example.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.model.Todo
import com.example.todo.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                TodoScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel = viewModel()
) {
    TodoList(modifier = modifier, todos = todoViewModel.todos)
}

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todos: List<Todo>
) {
    LazyColumn(
        modifier = modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}
