package de.akquinet.ats.kotlin.rest.resource

import de.akquinet.ats.kotlin.json.SpecialCalculation
import de.akquinet.ats.kotlin.json.StandardCalculation
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.amshove.kluent.`should be equal to`
import org.apache.commons.lang3.StringUtils
import org.junit.Before
import org.junit.Ignore
import org.junit.Test



class CalculatorResourceIT {

    val SERVICE = "appserver"

    private fun detectHttpPort(): Int {
        val port = 8080

        val offset = System.getProperties().getProperty("jboss.socket.binding.port-offset")
        if (StringUtils.isNotBlank(offset)) {
            return port + Integer.parseInt(offset)
        }

        return port
    }

    fun getUrl(url: String): String {
        val port = detectHttpPort()
        return "http://localhost:$port$url"
    }

    @Before
    fun setup() {
        RestAssured.baseURI = getUrl("/calculator/rest")
        RestAssured.basePath = "/operation"
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    fun `can GET add`() {
        val body = StandardCalculation(first = 3.0, second = 6.0)
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/add")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.XML)
                .extract().xmlPath().getDouble("result") `should be equal to` 9.0

    }

    @Test
    fun `can GET subtract`() {
        val body = StandardCalculation(first = 3.0, second = 6.0)
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/subtract")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.XML)
                .extract().xmlPath().getDouble("result") `should be equal to` -3.0

    }

    @Test
    fun `can GET multiply`() {
        val body = StandardCalculation(first = 3.0, second = 6.0)
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/multiply")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.XML)
                .extract().xmlPath().getDouble("result") `should be equal to` 18.0

    }

    @Test
    fun `can GET divide`() {
        val body = StandardCalculation(first = 3.0, second = 6.0)
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/divide")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.XML)
                .extract().xmlPath().getDouble("result") `should be equal to` 0.5

    }

    @Test
    @Ignore
    fun `can GET division by zero`() {
        val body = StandardCalculation(first = 3.0, second = 0.0)
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/divide")
                .then().assertThat().statusCode(400).and()
                .contentType(ContentType.TEXT)
                .extract().asString() `should be equal to` "Cannot divide by zero."

    }

    @Test
    fun `can GET sum`() {
        val body = SpecialCalculation(listOf(1.0, 5.0))
        given().body(body).accept(ContentType.XML).contentType(ContentType.XML)
                .`when`().post("/sum")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.XML)
                .extract().xmlPath().getDouble("result") `should be equal to` 6.0

    }
}
