package de.akquinet.ats.kotlin.jee.exception

import de.akquinet.ats.kotlin.calculator.CalculationException
import de.akquinet.ats.kotlin.json.CalculationError

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class CalculationExceptionMapper : ExceptionMapper<CalculationException> {

    override fun toResponse(exception: CalculationException?): Response {
        val error = CalculationError(message = exception?.message ?: "not set")
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build()
    }
}
