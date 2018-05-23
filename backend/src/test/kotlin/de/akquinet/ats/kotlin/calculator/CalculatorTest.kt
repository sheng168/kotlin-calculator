package de.akquinet.ats.kotlin.calculator

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.junit.Test

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun canAdd() {
        calculator.add(9.0, 10.0) `should be equal to` 19.0
    }

    @Test
    fun canSubtract() {
        calculator.subtract(3.0, 9.0) `should be equal to` -6.0
        calculator.subtract(3.0, 1.0) `should be equal to` 2.0
    }

    @Test
    fun canMultiply() {
        calculator.multiply(0.0, 2.0) `should be equal to` 0.0
        calculator.multiply(3.0, 2.0) `should be equal to` 6.0
    }

    @Test
    fun canDivide() {
        calculator.divide(10.0, 2.0) `should be equal to` 5.0
    }

    @Test
    fun cannotDivideByZero() {
        val divisionByZero = { calculator.divide(1.0, 0.0) }
        divisionByZero `should throw` CalculationException::class
    }

    @Test
    fun canSum() {
        val numbers = listOf(0.0, 2.0, 3.0, 5.0, 12.0)
        calculator.sum(numbers) `should be equal to` 22.0
    }

    @Test
    fun cannotSumNothing() {
        val sumOfNothing = { calculator.sum(emptyList()) }
        sumOfNothing `should throw` CalculationException::class
   }
}
