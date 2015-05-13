
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Specification of a reference point for range filtering of geocode properties.
 * 
 * <p>Classe Java de GeocodeReferencePoint complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GeocodeReferencePoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Latitude" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Longitude" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeocodeReferencePoint")
public class GeocodeReferencePoint {

    @XmlAttribute(name = "Latitude", required = true)
    protected double latitude;
    @XmlAttribute(name = "Longitude", required = true)
    protected double longitude;

    /**
     * Obt\u00e9m o valor da propriedade latitude.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Define o valor da propriedade latitude.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade longitude.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Define o valor da propriedade longitude.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

}
