package com.chessporg.todolist.ui.signupsuccess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.chessporg.todolist.R
import com.chessporg.todolist.ui.login.LoginActivity
import com.chessporg.todolist.ui.usertodos.UserTodoActivity

class SignUpSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_success)

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 2000)
    }
}