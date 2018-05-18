package de.akquinet.ats.kotlin.rest.resource

import com.palantir.docker.compose.DockerComposeRule
import com.palantir.docker.compose.connection.waiting.HealthChecks
import de.akquinet.ats.kotlin.json.StandardCalculation
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.amshove.kluent.`should be equal to`
import org.joda.time.Duration
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class CalculatorResourceIT {

    val SERVICE = "appserver"
    val TIMEOUT = Duration.standardMinutes(2)
    
    @Rule @JvmField
    val docker: DockerComposeRule = DockerComposeRule.builder()
            .file(CalculatorResourceIT::class.java.getResource("/docker-compose.yml").file)
            .waitingForService(SERVICE,
                    HealthChecks.toRespondOverHttp(8080) {
                        port -> port.inFormat("http://\$HOST:\$EXTERNAL_PORT")
                    }).build()


    fun getUrl(url: String): String {
        val proxy = docker.containers().container(SERVICE).port(8080)
        return proxy.inFormat("http://\$HOST:\$EXTERNAL_PORT$url")
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
}
