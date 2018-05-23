package de.akquinet.ats.kotlin.json

import org.amshove.kluent.`should be equal to`
import org.junit.Test

class CalculationResultTest {

    @Test
    fun `can create object`() {
        val body = CalculationResult()
        body.result `should be equal to` 0.0
    }

    @Test
    fun `can create object with value`() {
        val body = CalculationResult(4.3)
        body.result `should be equal to` 4.3
    }

}
