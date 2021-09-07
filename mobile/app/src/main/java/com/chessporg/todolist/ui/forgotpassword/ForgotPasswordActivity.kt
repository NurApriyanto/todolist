package com.chessporg.todolist.ui.forgotpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chessporg.todolist.R
import com.chessporg.todolist.databinding.ActivityForgotPasswordBinding
import com.chessporg.todolist.ui.emailresetpassword.EmailResetPasswordActivity
import com.chessporg.todolist.utils.helper.ErrorInputHelper
import com.chessporg.todolist.utils.helper.UserValidationHelper

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ErrorInputHelper.hideFieldError(tfEmail)
        }
        setBackButtonOnClickListener()
        setSignUpOnClickListener()
    }


    private fun setBackButtonOnClickListener() {
        binding.apply {
            civBackButton.setOnClickListener {
                finish()
            }
        }
    }

    private fun setSignUpOnClickListener() {
        binding.apply {
            civSendPassword.setOnClickListener {
                ErrorInputHelper.hideFieldError(tfEmail)

                val email = tfEmail.editText?.text.toString()

                if (UserValidationHelper.isValidEmail(email)) {
                    val intent = Intent(this@ForgotPasswordActivity, EmailResetPasswordActivity::class.java)
                    startActivity(intent)
                }
                else {
                    ErrorInputHelper.showFieldError(tfEmail, ErrorInputHelper.EMAIL_ERROR)
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.apply {
            ErrorInputHelper.showFieldError(tfEmail, ErrorInputHelper.EMAIL_ERROR)
        }
    }
}