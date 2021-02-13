package com.example.unittestpractice

object Calculator {

    fun sum(firstNumber: Double, secondNumber: Double) : Double{
        return firstNumber + secondNumber
    }

    fun subtract(firstNumber: Double, secondNumber: Double) : Double{
        return firstNumber - secondNumber
    }

    fun multiply(firstNumber: Double, secondNumber: Double) : Double{
        return firstNumber * secondNumber
    }

    fun divide(firstNumber: Double, secondNumber: Double) : Double? {
        return if (secondNumber != 0.0) firstNumber / secondNumber else null
    }
}