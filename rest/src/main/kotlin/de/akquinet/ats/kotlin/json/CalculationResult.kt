package de.akquinet.ats.kotlin.json

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class CalculationResult {

    @XmlElement var result: Double = 0.0

    constructor()

    constructor(result: Double) : this() {
        this.result = result
    }
}
