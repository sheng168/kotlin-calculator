package de.akquinet.ats.kotlin.calculator

class Calculator {

    fun add(summand1: Double, summand2: Double): Double {
        return summand1 + summand2
    }

    fun subtract(minuend: Double, subtrahend: Double): Double {
        return minuend - subtrahend
    }

    fun multiply(factor1: Double, factor2: Double): Double {
        return factor1 * factor2
    }

    fun divide(dividend: Double, divisor: Double): Double {
        if (divisor == 0.0) {
            throw CalculationException("Cannot divide by zero.")
        }

        return dividend / divisor
    }

    /**
     * method with uncovered branches
     */
    fun sum(numbers: List<Double>?): Double {
        if (numbers == null || numbers.isEmpty()) {
            throw CalculationException("Cannot calculate sum of nothing.")
        }

        return numbers.sum()
    }
}
