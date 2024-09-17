package com.example.androidtask1finalauth.utils

import android.util.Patterns
import java.util.regex.Pattern

object Validationutil {
    private val passwordRegex= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\$#!?@])[\\S]{8,16}\$"
    val name = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*\$"
    fun isValidEmail(email: String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    fun isValidPassword(password: String): Boolean {
        return Pattern.compile(passwordRegex).matcher(password).matches()
    }
    fun isValidName(fname: String): Boolean {
        return Pattern.compile(name).matcher(fname).matches()
    }
}