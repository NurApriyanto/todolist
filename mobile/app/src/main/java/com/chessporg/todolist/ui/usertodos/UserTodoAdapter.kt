package com.chessporg.todolist.ui.usertodos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chessporg.todolist.R
import com.chessporg.todolist.data.model.TodoItem
import com.chessporg.todolist.databinding.ItemTodoBinding

class UserTodoAdapter : RecyclerView.Adapter<UserTodoAdapter.UserTodoViewHolder>() {

    private val list = ArrayList<TodoItem>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(userTodos: ArrayList<TodoItem>) {
        list.clear()
        list.addAll(userTodos)
        notifyDataSetChanged()
    }

    inner class UserTodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userTodo: TodoItem) {
            binding.apply {
                tvTaskTitle.text = userTodo.taskTitle
            }
        }
    }

    var clickedCount = 0
    var checkedCount = 0
    var deletedCount = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserTodoAdapter.UserTodoViewHolder {
        return UserTodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserTodoAdapter.UserTodoViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.apply {
            setOnClickListener {
                Log.d("Test item", "Clicked $clickedCount")
                clickedCount++
            }

            findViewById<ImageView>(R.id.btn_check).setOnClickListener {
                Log.d("Test item", "Checked $checkedCount")
                checkedCount++
            }
            findViewById<TextView>(R.id.btn_delete).setOnClickListener {
                Log.d("Test item", "Deleted $deletedCount")
                deletedCount++
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(todoItem: TodoItem)
    }
}