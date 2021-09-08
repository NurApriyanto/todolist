package com.chessporg.todolist.ui.usertodos

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chessporg.todolist.R
import com.chessporg.todolist.data.model.TodoItem
import com.chessporg.todolist.databinding.ActivityUserTodoBinding
import com.chessporg.todolist.ui.login.LoginActivity
import com.chessporg.todolist.utils.helper.UserData
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputLayout

class UserTodoActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val USER_ID = "user_id"
    }

    private lateinit var binding: ActivityUserTodoBinding
    private lateinit var viewModel: UserTodoViewModel
    private lateinit var userTodoAdapter: UserTodoAdapter

    private lateinit var dialogBuilder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(UserTodoViewModel::class.java)

        // init dummy data
        viewModel.addDummyListTodos(UserData.userTodoItems)

        setTodosAdapter()
        setDrawerOnClickListener()
        setNameProfile()
        setAddOnClickListener()
    }

    private fun setAddOnClickListener() {
        binding.btnAdd.setOnClickListener {
            createNewFeedbackDialog(null, null)
        }
    }

    private fun createNewFeedbackDialog(todoItem: TodoItem?, index: Int?) {
        dialogBuilder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.layout_dialog_task, null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()

        when {
            todoItem != null -> {
                view.apply {
                    val tfTaskName = findViewById<TextInputLayout>(R.id.tf_task_name).editText
                    val tfTaskDescription =
                        findViewById<TextInputLayout>(R.id.tf_task_description).editText

                    tfTaskName?.setText(todoItem.taskTitle)
                    tfTaskDescription?.setText(todoItem.taskDescription)
                    findViewById<TextView>(R.id.tv_dialog_task_title).text =
                        getString(R.string.edit_task)
                }
            }

            else -> {
                view.findViewById<TextView>(R.id.tv_dialog_task_title).text =
                    getString(R.string.add_new_task)
            }
        }

        view.findViewById<CardView>(R.id.btn_submit_task).setOnClickListener {
            val tfTaskName = view.findViewById<TextInputLayout>(R.id.tf_task_name)
            val taskName = tfTaskName.editText?.text.toString()
            tfTaskName.isErrorEnabled = false
            val tfTaskDescription = view.findViewById<TextInputLayout>(R.id.tf_task_description)
            val taskDescription = tfTaskDescription.editText?.text.toString()
            tfTaskDescription.isErrorEnabled = false

            if (taskName == "") {
                tfTaskName.error = getString(R.string.task_name_error)
                tfTaskName.isErrorEnabled = true
            }
            if (taskDescription == "") {
                tfTaskDescription.error = getString(R.string.task_description_error)
                tfTaskDescription.isErrorEnabled = true
            }

            if (taskName != "" && taskDescription != "") {
                when {
                    index != null -> {
                        viewModel.updateTodoItem(
                            index,
                            taskName,
                            taskDescription,
                            todoItem!!.isChecked
                        )
                    }
                    else -> {
                        viewModel.addTodoItem(taskName, taskDescription)
                        viewModel.getListTodos().observe(this, {
                            userTodoAdapter.setList(it)
                        })
                    }
                }

                dialog.dismiss()
            }
        }
    }

    private fun updateTotalTask() {
        binding.apply {
            val item = navView.menu.getItem(0)
            item.title = userTodoAdapter.itemCount.toString() + " Task Total"
        }
    }

    private fun setNameProfile() {
        binding.apply {
            val header = navView.getHeaderView(0)
            val fullName: TextView = header.findViewById(R.id.tv_header_profile_name)

            viewModel.getUsername(UserData.userToken).observe(this@UserTodoActivity, {
                fullName.text = it
            })
        }
    }

    private fun setTodosAdapter() {
        userTodoAdapter = UserTodoAdapter()
        binding.apply {
            rvTodos.layoutManager = LinearLayoutManager(this@UserTodoActivity)
            rvTodos.setHasFixedSize(true)
            rvTodos.adapter = userTodoAdapter
        }

        userTodoAdapter.setOnItemClickCallback(object : UserTodoAdapter.OnItemClickCallback {
            override fun onItemClicked(todoItem: TodoItem, index: Int) {
                createNewFeedbackDialog(todoItem, index)
            }
        })

        userTodoAdapter.setOnIconTrashClickCallback(object :
            UserTodoAdapter.OnIconTrashClickCallback {
            override fun onIconClicked(index: Int) {
                viewModel.removeTodoItem(index)
                viewModel.getListTodos().observe(this@UserTodoActivity, {
                    userTodoAdapter.setList(it)
                })
                updateTotalTask()
            }
        })

        viewModel.getListTodos().observe(this, {
            if (it != null) {
                userTodoAdapter.setList(it)
            }
        })

        updateTotalTask()

    }

    private fun setDrawerOnClickListener() {
        val drawerButton: ImageView = findViewById(R.id.iv_drawer)

        drawerButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.nav_log_out -> {
                viewModel.removeTokenFromSharedPref(this)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }

            else -> true
        }
    }
}
