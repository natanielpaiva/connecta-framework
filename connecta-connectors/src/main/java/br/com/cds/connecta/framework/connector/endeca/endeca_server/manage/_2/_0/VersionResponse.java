
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DgraphVersion;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.endeca_server.types._2._0.DgraphVersion;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dgraphVersion" type="{http://www.endeca.com/endeca-server/types/2/0}dgraphVersion" maxOccurs="unbounded" minOccurs="0"/>
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
    "serverVersion",
    "dgraphVersion"
})
@XmlRootElement(name = "versionResponse")
public class VersionResponse {

    @XmlElement(required = true)
    protected String serverVersion;
    protected List<DgraphVersion> dgraphVersion;

    /**
     * Obt\u00e9m o valor da propriedade serverVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Define o valor da propriedade serverVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerVersion(String value) {
        this.serverVersion = value;
    }

    /**
     * Gets the value of the dgraphVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dgraphVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDgraphVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DgraphVersion }
     * 
     * 
     */
    public List<DgraphVersion> getDgraphVersion() {
        if (dgraphVersion == null) {
            dgraphVersion = new ArrayList<DgraphVersion>();
        }
        return this.dgraphVersion;
    }

}
