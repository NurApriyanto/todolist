package com.chessporg.todolist.utils

import com.chessporg.todolist.data.model.TodoItem

object dummyData {
    fun addDummyTodoList(): ArrayList<TodoItem> {
        val listTodo = ArrayList<TodoItem>()
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        listTodo.add(TodoItem(1, "Test", "Test", "01-01-2001"))
        return listTodo
    }
}