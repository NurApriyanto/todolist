package com.chessporg.todolist.ui.usertodos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chessporg.todolist.utils.dummyData
import com.chessporg.todolist.databinding.ActivityUserTodoBinding

class UserTodoActivity : AppCompatActivity() {

    companion object {
        const val USER_ID = "user_id"
    }

    private lateinit var binding: ActivityUserTodoBinding
    private lateinit var viewModel: UserTodoViewModel
    private lateinit var userTodoAdapter : UserTodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(UserTodoViewModel::class.java)

        setTodosAdapter()
    }

    private fun setTodosAdapter() {
        userTodoAdapter = UserTodoAdapter()
        userTodoAdapter.setList(dummyData.addDummyTodoList())
        binding.apply {
            rvTodos.layoutManager = LinearLayoutManager(this@UserTodoActivity)
            rvTodos.setHasFixedSize(true)
            rvTodos.adapter = userTodoAdapter
        }
    }
}