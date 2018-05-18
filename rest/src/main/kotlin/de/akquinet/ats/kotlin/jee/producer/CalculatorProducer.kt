package de.akquinet.ats.kotlin.jee.producer

import de.akquinet.ats.kotlin.calculator.Calculator
import javax.enterprise.inject.Produces

class CalculatorProducer {

    @Produces
    fun produce(): Calculator {
        return Calculator()
    }
}
