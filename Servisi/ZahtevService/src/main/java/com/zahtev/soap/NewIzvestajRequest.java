//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.07.11 at 09:12:36 PM CEST 
//


package com.zahtev.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izvestaj" type="{http://zahtev.com/soap}izvestaj"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "izvestaj"
})
@XmlRootElement(name = "newIzvestajRequest")
public class NewIzvestajRequest {

    @XmlElement(required = true)
    protected Izvestaj izvestaj;

    /**
     * Gets the value of the izvestaj property.
     * 
     * @return
     *     possible object is
     *     {@link Izvestaj }
     *     
     */
    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    /**
     * Sets the value of the izvestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Izvestaj }
     *     
     */
    public void setIzvestaj(Izvestaj value) {
        this.izvestaj = value;
    }

}
