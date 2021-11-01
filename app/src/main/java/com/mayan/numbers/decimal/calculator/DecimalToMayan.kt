package com.mayan.numbers.decimal.calculator

import java.util.ArrayList

class DecimalToMayan {

    fun getNumerics(decimalNumber: Int): ArrayList<Int> {
        var num: Int = decimalNumber
        val numbers = arrayListOf<Int>()
        val increment = 1
        while (num != 0) {
            val divisor: Float = increment * 20.0f
            var newNumber: Int = (num / divisor).toInt()
            newNumber = (newNumber * divisor).toInt()
            val reminder: Int = (num - newNumber)
            numbers.add(reminder)
            num = newNumber / 20
        }
        val newNumbers = arrayListOf<Int>()
        for (number in numbers) {
            newNumbers.add(0, number)
        }
        return newNumbers
    }

}
