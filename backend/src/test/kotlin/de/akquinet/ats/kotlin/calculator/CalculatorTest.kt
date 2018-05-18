package de.akquinet.ats.kotlin.calculator

import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should throw`
import org.junit.Test

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun canAdd() {
        calculator.add(9.0, 10.0) `should equal` 19.0
    }

    @Test
    fun canSubtract() {
        calculator.subtract(3.0, 9.0) `should equal` -6.0
        calculator.subtract(3.0, 1.0) `should equal` 2.0
    }

    @Test
    fun canMultiply() {
        calculator.multiply(0.0, 2.0) `should equal` 0.0
        calculator.multiply(3.0, 2.0) `should equal` 6.0
    }

    @Test
    fun canDivide() {
        calculator.divide(10.0, 2.0) `should equal` 5.0
    }

    @Test
    fun cannotDivideByZero() {
        val divisionByZero = { calculator.divide(1.0, 0.0) }
        divisionByZero `should throw` RuntimeException::class
    }

    @Test
    fun canSum() {
        val numbers = listOf(0.0, 2.0, 3.0, 5.0, 12.0)
        calculator.sum(numbers) `should equal` 22.0
    }
}
