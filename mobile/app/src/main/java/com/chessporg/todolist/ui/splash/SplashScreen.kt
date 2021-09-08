package com.chessporg.todolist.ui.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.chessporg.todolist.R
import com.chessporg.todolist.ui.login.LoginActivity
import com.chessporg.todolist.ui.usertodos.UserTodoActivity
import com.chessporg.todolist.utils.helper.UserData

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPref = getSharedPreferences(getString(R.string.user_data), Context.MODE_PRIVATE)
        sharedPref.getInt(getString(R.string.saved_token), 0).also {
            UserData.userToken = it
        }

        if (UserData.userToken != 0) {
            gotoScreenWithDelay(Intent(this, UserTodoActivity::class.java))
        } else {
            gotoScreenWithDelay(Intent(this, LoginActivity::class.java))
        }

    }

    private fun gotoScreenWithDelay(intent: Intent) {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, 2000)
    }
}