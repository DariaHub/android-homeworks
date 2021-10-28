package com.example.app


class Validator {
    fun password_restriction(password: String): Boolean{
        var result = false
        if(password.length >= 8){
            result = true
        }
        return result
    }

    fun email_restriction(Email: String): Boolean{
        var result = false
        if(Email.length >= 7)
            result = true
        if (Email.contains("@"))
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