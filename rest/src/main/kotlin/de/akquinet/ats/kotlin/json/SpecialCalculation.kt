package de.akquinet.ats.kotlin.json

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class SpecialCalculation {

    @XmlElement var numbers: List<Double>? = null

    constructor()

    constructor(numbers: List<Double>) : this() {
        this.numbers = numbers
    }


}
