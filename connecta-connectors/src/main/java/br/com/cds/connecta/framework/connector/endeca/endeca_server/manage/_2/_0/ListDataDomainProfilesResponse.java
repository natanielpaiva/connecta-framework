
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DataDomainProfile;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.endeca_server.types._2._0.DataDomainProfile;


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
 *         &lt;element name="dataDomainProfile" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainProfile" maxOccurs="unbounded" minOccurs="0"/>
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
    "dataDomainProfile"
})
@XmlRootElement(name = "listDataDomainProfilesResponse")
public class ListDataDomainProfilesResponse {

    protected List<DataDomainProfile> dataDomainProfile;

    /**
     * Gets the value of the dataDomainProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataDomainProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataDomainProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataDomainProfile }
     * 
     * 
     */
    public List<DataDomainProfile> getDataDomainProfile() {
        if (dataDomainProfile == null) {
            dataDomainProfile = new ArrayList<DataDomainProfile>();
        }
        return this.dataDomainProfile;
    }

}
