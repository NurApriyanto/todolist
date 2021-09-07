package com.chessporg.todolist.utils.helper

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

object ErrorInputHelper {

    const val EMAIL_ERROR = "Email is not valid or registered"
    const val PASSWORD_ERROR = "Password must be minimum ${UserValidationHelper.PASSWORD_MIN_SIZE} character"
    const val CONFIRM_PASSWORD_ERROR = "Confirm password is different from password"
    const val CHECKBOX_ERROR = "Checkbox must be checked"

    fun <T> showFieldError(v: T, errorText: String? = null) {
        when(v) {
            is TextInputLayout -> {
                v.isErrorEnabled = true
                v.error = errorText
            }
            is TextView -> {
                v.visibility = View.VISIBLE
            }
        }
    }

    fun <T> hideFieldError(v: T) {
        when(v) {
            is ArrayList<*> -> {
                v.map {
                    (it as TextInputLayout).apply {
                        this.isErrorEnabled = false
                        this.error = ""
                    }
                }
            }
            is TextInputLayout -> {
                v.isErrorEnabled = false
                v.error = ""
            }
        }
    }
}