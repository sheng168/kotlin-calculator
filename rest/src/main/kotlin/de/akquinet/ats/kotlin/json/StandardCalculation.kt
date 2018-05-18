package de.akquinet.ats.kotlin.json

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class StandardCalculation {

    @XmlElement var first: Double = 0.0
    @XmlElement var second: Double = 0.0

    constructor()

    constructor(first: Double, second: Double) : this() {
        this.first = first
        this.second = second
    }
}
