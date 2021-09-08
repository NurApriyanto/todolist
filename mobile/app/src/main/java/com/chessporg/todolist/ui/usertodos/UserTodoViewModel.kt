package com.chessporg.todolist.ui.usertodos

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chessporg.todolist.R
import com.chessporg.todolist.data.model.TodoItem
import com.chessporg.todolist.utils.dummyData
import kotlin.random.Random

class UserTodoViewModel : ViewModel() {
    private val listTodos = MutableLiveData<ArrayList<TodoItem>>()
    private val username = MutableLiveData<String>()

    fun addDummyListTodos(list: ArrayList<TodoItem>) {
        listTodos.postValue(list)
    }

    fun setListTodos() {
        listTodos.postValue(arrayListOf<TodoItem>())
    }

    fun addTodoItem(taskName: String, taskDesription: String) {
        listTodos.value?.add(TodoItem(Random.nextInt(), taskName, taskDesription, ""))
    }

    fun updateTodoItem(index: Int, taskTitle: String, taskDescription: String, checked: Boolean) {
        listTodos.value?.apply {
            removeAt(index)
            add(index, TodoItem(Random.nextInt(), taskTitle, taskDescription, "", checked))
        }
    }

    fun removeTodoItem(index: Int) {
        listTodos.value?.apply {
            removeAt(index)
        }
    }

    fun getListTodos(): LiveData<ArrayList<TodoItem>> {
        return listTodos
    }

    fun getUsername(token: Int): LiveData<String> {
        username.postValue("Fikran Akbar")
        return username
    }

    fun removeTokenFromSharedPref(context: Context) {
        context.apply {
            val sharedPref = getSharedPreferences(getString(R.string.user_data), Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                remove(getString(R.string.saved_token))
                apply()
            }
        }
    }
}