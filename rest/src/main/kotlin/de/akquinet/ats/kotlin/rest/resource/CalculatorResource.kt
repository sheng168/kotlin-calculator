package de.akquinet.ats.kotlin.rest.resource

import de.akquinet.ats.kotlin.calculator.Calculator
import de.akquinet.ats.kotlin.json.CalculationResult
import de.akquinet.ats.kotlin.json.SpecialCalculation
import de.akquinet.ats.kotlin.json.StandardCalculation
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.ADD
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.DIVIDE
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.MULTIPLY
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.OPERATION
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.SUBTRACT
import de.akquinet.ats.kotlin.rest.app.CalculatorApp.Companion.SUM
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_XML
import javax.ws.rs.core.Response

@Path(OPERATION)
@Consumes(APPLICATION_XML)
@Produces(APPLICATION_XML)
class CalculatorResource {

    private val calculator = Calculator()

    @POST
    @Path(ADD)
    fun add(body: StandardCalculation): Response {
        val result = calculator.add(body.first, body.second)
        return Response.ok(CalculationResult(result)).build()
    }

    @POST
    @Path(SUBTRACT)
    fun subtract(body: StandardCalculation): Response {
        val result = calculator.subtract(body.first, body.second)
        return Response.ok(CalculationResult(result)).build()
    }

    @POST
    @Path(MULTIPLY)
    fun multiply(body: StandardCalculation): Response {
        val result = calculator.multiply(body.first, body.second)
        return Response.ok(CalculationResult(result)).build()
    }

    @POST
    @Path(DIVIDE)
    fun divide(body: StandardCalculation): Response {
        val result = calculator.divide(body.first, body.second)
        return Response.ok(CalculationResult(result)).build()
    }

    @POST
    @Path(SUM)
    fun sum(body: SpecialCalculation): Response {
        val result = calculator.sum(body.numbers)
        return Response.ok(CalculationResult(result)).build()
    }
}
