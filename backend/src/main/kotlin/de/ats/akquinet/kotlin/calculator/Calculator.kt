package de.ats.akquinet.kotlin.calculator

class Calculator {

    fun add(summand1: Number, summand2: Number): Number {
        return summand1.toDouble() + summand2.toDouble()
    }

    fun subtract(minuend: Number, subtrahend: Number): Number {
        return minuend.toDouble() - subtrahend.toDouble()
    }

    fun multiply(factor1: Number, factor2: Number): Number {
        return factor1.toDouble() * factor2.toDouble()
    }

    fun divide(dividend: Number, divisor: Number): Number {
        if (divisor == 0) {
            throw RuntimeException("Divisor cannot be zero.")
        }

        return dividend.toDouble() / divisor.toDouble()
    }
}
