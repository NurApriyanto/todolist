package com.chessporg.todolist.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chessporg.todolist.R
import com.chessporg.todolist.databinding.ActivitySignUpBinding
import com.chessporg.todolist.ui.login.LoginActivity
import com.chessporg.todolist.ui.signupsuccess.SignUpSuccessActivity
import com.chessporg.todolist.utils.helper.ErrorInputHelper
import com.chessporg.todolist.utils.helper.UserValidationHelper

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ErrorInputHelper.hideFieldError(arrayListOf(tfEmail, tfPassword, tfConfirmPassword))
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
            civSignUp.setOnClickListener {
                ErrorInputHelper.hideFieldError(arrayListOf(tfEmail, tfPassword, tfConfirmPassword))

                val email = tfEmail.editText?.text.toString()
                val password = tfPassword.editText?.text.toString()
                val confirmPassword = tfConfirmPassword.editText?.text.toString()
                val isChecked = cbAgreement.isChecked

                if (UserValidationHelper.isValidEmail(email) &&
                    UserValidationHelper.isValidPassword(password) &&
                    UserValidationHelper.isValidPassword(confirmPassword) &&
                    UserValidationHelper.isValidConfirmPassword(password, confirmPassword) &&
                    isChecked) {
                    val intent = Intent(this@SignUpActivity, SignUpSuccessActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    if (!UserValidationHelper.isValidEmail(email)) {
                        ErrorInputHelper.showFieldError(tfEmail, ErrorInputHelper.EMAIL_ERROR)
                    }
                    if (!UserValidationHelper.isValidPassword(password)) {
                        ErrorInputHelper.showFieldError(tfPassword, ErrorInputHelper.PASSWORD_ERROR)
                    }
                    if (!UserValidationHelper.isValidPassword(confirmPassword)) {
                        ErrorInputHelper.showFieldError(tfConfirmPassword, ErrorInputHelper.PASSWORD_ERROR)
                    }
                    if (!UserValidationHelper.isValidConfirmPassword(password, confirmPassword)) {
                        ErrorInputHelper.showFieldError(tfConfirmPassword, ErrorInputHelper.CONFIRM_PASSWORD_ERROR)
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.apply {
            ErrorInputHelper.hideFieldError(arrayListOf(tfEmail, tfPassword, tfConfirmPassword))
        }
    }
}