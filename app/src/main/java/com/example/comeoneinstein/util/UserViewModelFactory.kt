package com.example.comeoneinstein.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.comeoneinstein.model.User

class UserViewModelFactory(private val countReserved: String,
                           private val passwordReserved: String,
                           private val isRememberReserved: Boolean,
                           private val isLoginReserved : Boolean): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return User(countReserved,passwordReserved,isRememberReserved,isLoginReserved) as T
    }
}