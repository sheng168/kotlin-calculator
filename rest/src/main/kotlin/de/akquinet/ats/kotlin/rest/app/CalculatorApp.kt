package de.akquinet.ats.kotlin.rest.app

import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.BASE
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath(BASE)
class CalculatorApp : Application() {

    companion object {
        const val BASE = "/rest"

        const val OPERATION = "/operation"

        const val ADD = "/add"
        const val SUBTRACT = "/subtract"
        const val MULTIPLY = "/multiply"
        const val DIVIDE = "/divide"
        const val SUM = "/sum"
    }
}
