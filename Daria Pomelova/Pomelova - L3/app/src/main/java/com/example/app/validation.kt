package com.example.app


class Validator {
    fun password_restriction(password: String): Boolean{
        var result = false
        if(password.length >= 8){
            result = true
        }
        return result
    }

    fun email_restriction(email: String): Boolean{
        var result = false
        if(email.length >= 7)
            result = true
        if (email.contains("@"))
            result = true
        return result
    }

    fun confirm_password(password: String, password2: String): Boolean{
        var result = false
        if(password == password2)
            result = true
        return result
    }
}