package com.chessporg.todolist.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.chessporg.todolist.databinding.ActivityLoginBinding
import com.chessporg.todolist.ui.forgotpassword.ForgotPasswordActivity
import com.chessporg.todolist.ui.signup.SignUpActivity
import com.chessporg.todolist.ui.usertodos.UserTodoActivity
import com.chessporg.todolist.utils.helper.ErrorInputHelper
import com.chessporg.todolist.utils.helper.UserValidationHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(LoginViewModel::class.java)

        binding.apply {
            ErrorInputHelper.hideFieldError(arrayListOf(tfEmail, tfPassword))
        }
        setSignInOnClickListener()
        setForgetPasswordOnClickListener()
        setSignUpOnClickListener()
    }

    private fun setSignUpOnClickListener() {
        binding.apply {
            tvSignup.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setForgetPasswordOnClickListener() {
        binding.apply {
            tvForgotYourPassword.setOnClickListener {
                val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSignInOnClickListener() {
        binding.apply {
            btnSignIn.setOnClickListener {

                ErrorInputHelper.hideFieldError(arrayListOf(tfEmail, tfPassword))

                val email = tfEmail.editText?.text.toString()
                val password = tfPassword.editText?.text.toString()

                if (UserValidationHelper.isValidEmail(email) &&
                    UserValidationHelper.isValidPassword(password)) {
                        moveToUserTodoScreen("Fikran Akbar")
                }
                else {
                    if (!UserValidationHelper.isValidEmail(email)) {
                        ErrorInputHelper.showFieldError(tfEmail, ErrorInputHelper.EMAIL_ERROR)
                    }
                    if (!UserValidationHelper.isValidPassword(password)) {
                        ErrorInputHelper.showFieldError(tfPassword, ErrorInputHelper.PASSWORD_ERROR)
                    }
                }
            }
        }
    }

    private fun moveToUserTodoScreen(username: String) {
        val intent = Intent(this, UserTodoActivity::class.java)
        intent.putExtra(UserTodoActivity.USER_ID, username)
        startActivity(intent)
        finish()
    }
}