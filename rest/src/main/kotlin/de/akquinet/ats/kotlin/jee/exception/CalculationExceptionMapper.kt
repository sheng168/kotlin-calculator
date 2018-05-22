package de.akquinet.ats.kotlin.jee.exception

import de.akquinet.ats.kotlin.calculator.CalculationException
import sun.security.timestamp.TSResponse.BAD_REQUEST
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class CalculationExceptionMapper : ExceptionMapper<CalculationException> {

    override fun toResponse(exception: CalculationException?): Response {
        return Response.status(BAD_REQUEST).entity(exception?.message).build()
    }
}
