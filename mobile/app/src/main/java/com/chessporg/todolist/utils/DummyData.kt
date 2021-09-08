package com.chessporg.todolist.utils

import com.chessporg.todolist.data.model.TodoItem

object dummyData {
    fun addDummyTodoList(): ArrayList<TodoItem> {
        val listTodo = ArrayList<TodoItem>()
        listTodo.add(TodoItem(1, "Nama Task 1", "Deskripsi Task 1", "01-01-2001"))
        listTodo.add(TodoItem(2, "Nama Task 2", "Deskripsi Task 2", "01-01-2001"))
        listTodo.add(TodoItem(3, "Nama Task 3", "Deskripsi Task 3", "01-01-2001"))
        listTodo.add(TodoItem(4, "Nama Task 4", "Deskripsi Task 4", "01-01-2001"))
        return listTodo
    }
}