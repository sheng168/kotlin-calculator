package de.akquinet.ats.kotlin.json

import org.amshove.kluent.`should be equal to`
import org.junit.Test

class StandardCalculationTest {

    @Test
    fun `can create object`() {
        val body = StandardCalculation(first = 3.0, second = 6.0)
        body.first `should be equal to` 3.0
        body.second `should be equal to` 6.0
    }
}

