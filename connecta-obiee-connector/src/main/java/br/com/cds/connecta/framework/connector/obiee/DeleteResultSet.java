
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.ArrayOfGUIDs;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetLevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GUIDs" type="{urn://oracle.bi.webservices/v6}arrayOfGUIDs"/>
 *         &lt;element name="segmentPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "targetLevel",
    "guiDs",
    "segmentPath",
    "sessionID"
})
@XmlRootElement(name = "deleteResultSet")
public class DeleteResultSet {

    @XmlElement(required = true)
    protected String targetLevel;
    @XmlElement(name = "GUIDs", required = true)
    protected ArrayOfGUIDs guiDs;
    protected String segmentPath;
    protected String sessionID;

    /**
     * Obtém o valor da propriedade targetLevel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetLevel() {
        return targetLevel;
    }

    /**
     * Define o valor da propriedade targetLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetLevel(String value) {
        this.targetLevel = value;
    }

    /**
     * Obtém o valor da propriedade guiDs.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGUIDs }
     *     
     */
    public ArrayOfGUIDs getGUIDs() {
        return guiDs;
    }

    /**
     * Define o valor da propriedade guiDs.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGUIDs }
     *     
     */
    public void setGUIDs(ArrayOfGUIDs value) {
        this.guiDs = value;
    }

    /**
     * Obtém o valor da propriedade segmentPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentPath() {
        return segmentPath;
    }

    /**
     * Define o valor da propriedade segmentPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentPath(String value) {
        this.segmentPath = value;
    }

    /**
     * Obtém o valor da propriedade sessionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Define o valor da propriedade sessionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
