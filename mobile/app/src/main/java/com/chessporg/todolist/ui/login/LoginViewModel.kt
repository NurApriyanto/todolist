package com.chessporg.todolist.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chessporg.todolist.R

class LoginViewModel : ViewModel() {

    private var token = MutableLiveData<Int>()

    fun setUserToken(token: Int, context: Context) {
        context.apply {
            val sharedPref = getSharedPreferences(getString(R.string.user_data), Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putInt(getString(R.string.saved_token), token)
                apply()
            }
        }
    }

    fun getUserStatus(email: String, password: String) : LiveData<Int> {
        token.postValue(12345)
        return token
    }
}