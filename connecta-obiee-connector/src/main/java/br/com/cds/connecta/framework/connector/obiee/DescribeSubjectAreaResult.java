
package br.com.cds.connecta.framework.connector.obiee;

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
 *         &lt;element name="subjectArea" type="{urn://oracle.bi.webservices/v6}SASubjectArea"/>
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
    "subjectArea"
})
@XmlRootElement(name = "describeSubjectAreaResult")
public class DescribeSubjectAreaResult {

    @XmlElement(required = true)
    protected SASubjectArea subjectArea;

    /**
     * Obtém o valor da propriedade subjectArea.
     * 
     * @return
     *     possible object is
     *     {@link SASubjectArea }
     *     
     */
    public SASubjectArea getSubjectArea() {
        return subjectArea;
    }

    /**
     * Define o valor da propriedade subjectArea.
     * 
     * @param value
     *     allowed object is
     *     {@link SASubjectArea }
     *     
     */
    public void setSubjectArea(SASubjectArea value) {
        this.subjectArea = value;
    }

}
