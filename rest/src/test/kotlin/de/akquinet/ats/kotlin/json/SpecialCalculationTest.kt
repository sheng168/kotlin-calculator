package de.akquinet.ats.kotlin.json

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should not be`
import org.junit.Test

class SpecialCalculationTest {

    @Test
    fun `can create object`() {
        val numbers = listOf(1.0, 4.0)
        val body = SpecialCalculation(numbers)

        body.numbers `should not be` null
        body.numbers!!.isNotEmpty() `should be equal to` true
    }

}
