package de.ats.akquinet.kotlin.calculator

import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should throw`
import org.junit.Test

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun canAdd() {
        calculator.add(9, 10) `should equal` 19.toDouble()
    }

    @Test
    fun canSubtract() {
        calculator.subtract(3, 9) `should equal` (-6).toDouble()
        calculator.subtract(3, 1) `should equal` 2.toDouble()
    }

    @Test
    fun canMultiply() {
        calculator.multiply(0, 2) `should equal` 0.toDouble()
        calculator.multiply(3, 2) `should equal` 6.toDouble()
    }

    @Test
    fun canDivide() {
        calculator.divide(10, 2) `should equal` 5.toDouble()
    }

    @Test
    fun cannotDivideByZero() {
        val invalidDivision = { calculator.divide(1, 0) }
        invalidDivision `should throw` RuntimeException::class
    }
}
