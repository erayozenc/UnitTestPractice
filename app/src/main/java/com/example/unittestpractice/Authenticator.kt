package com.example.unittestpractice

import java.util.regex.Pattern

object Authenticator {

    private val userList = listOf( //<User> gerek yok
            User("Brad","Pitt","bradpitt@hotmail.com","asd123")
    )

    fun register(
            name : String,
            surname : String,
            email: String,
            password: String,
            confirmPassword: String
    ) : Boolean {
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
            return false
        if (!email.contains("@") || !email.contains("."))//android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches(); -> Mail check
            return false
        if (!isValidPassword(password)) // rule mantığına gerek var mı  yada farklu bir rule olabilir
            return false
        if (password != confirmPassword)
            return false
        userList.map {
            if (it.email == email)
                return false
        }
       // val newUser = User(name, surname, email, password) -> gereksiz kod
        return true

    }

    private fun isValidPassword(password: String) : Boolean {
         val PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=\\S+$)" +           //no white spaces
                        ".{6,}" +               //at least 4 characters
                        "$")

        return PASSWORD_PATTERN.matcher(password).matches()
    }

    fun loginWithEmailAndPassword(email : String, password: String) : Boolean {
        if (email.isEmpty() || password.isEmpty())
            return false
        userList.map {
            if (it.email == email){
                return it.password == password //if true logged in, if false wrong password
            }
        }
        return false //There is any account with this e-mail
    }

    fun forgetPassword(email: String) : String {
        userList.map {
            if (it.email == email)
                return "TOKEN"
        }
        return "ERROR"
    }

    fun changePassword(token : String) : Boolean {
        return token == "TOKEN"
    }
}

data class User(val name: String,val surname: String,val email: String, val password: String)