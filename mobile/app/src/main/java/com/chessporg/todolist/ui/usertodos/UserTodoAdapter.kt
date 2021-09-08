package com.chessporg.todolist.ui.usertodos

import android.content.res.Resources
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chessporg.todolist.R
import com.chessporg.todolist.data.model.TodoItem
import com.chessporg.todolist.databinding.ItemTodoBinding

class UserTodoAdapter : RecyclerView.Adapter<UserTodoAdapter.UserTodoViewHolder>() {

    private val list = ArrayList<TodoItem>()

    private var onItemClickCallback: OnItemClickCallback? = null
    private var onIconTrashClickCallback: OnIconTrashClickCallback? = null

    fun setCheckBoxStatus(
        tvTaskName: TextView,
        rootView: View,
        resources: Resources,
        position: Int,
        isChecked: Boolean
    ) {
        list[position].isChecked = isChecked
        when (list[position].isChecked) {
            true -> {
                tvTaskName.paintFlags = tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                rootView.setBackgroundColor(resources.getColor(R.color.item_checked_bgcolor))
            }
            false -> {
                tvTaskName.paintFlags =
                    tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                rootView.setBackgroundColor(resources.getColor(R.color.item_unchecked_bgcolor))
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setOnIconTrashClickCallback(onIconTrashClickCallback: OnIconTrashClickCallback) {
        this.onIconTrashClickCallback = onIconTrashClickCallback
    }

    fun setList(userTodos: ArrayList<TodoItem>) {
        list.clear()
        list.addAll(userTodos)
        notifyDataSetChanged()
    }

    inner class UserTodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userTodo: TodoItem) {
            binding.apply {
                tvTaskTitle.text = userTodo.taskTitle
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserTodoAdapter.UserTodoViewHolder {
        return UserTodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserTodoAdapter.UserTodoViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.apply {
            val trashButton = findViewById<ImageView>(R.id.btn_delete)
            val checkBox = findViewById<CheckBox>(R.id.cb_taskCheck)
            val tvTaskName = findViewById<TextView>(R.id.tv_task_title)
            val rootView = checkBox.parent as View
            checkBox.isChecked = list[position].isChecked
            setCheckBoxStatus(tvTaskName, rootView, resources, position, checkBox.isChecked)

            setOnClickListener {
                onItemClickCallback?.onItemClicked(list[position], position)
            }

            checkBox.setOnClickListener {
                setCheckBoxStatus(tvTaskName, rootView, resources, position, checkBox.isChecked)
            }

            trashButton.setOnClickListener {
                onIconTrashClickCallback?.onIconClicked(position)
                tvTaskName.paintFlags = tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                rootView.setBackgroundColor(resources.getColor(R.color.item_unchecked_bgcolor))
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(todoItem: TodoItem, index: Int)
    }

    interface OnIconTrashClickCallback {
        fun onIconClicked(index: Int)
    }

    interface OnCheckboxClickCallback {
        fun onCheckboxClicked(todoItem: TodoItem, index: Int, cb: CheckBox)
    }
}