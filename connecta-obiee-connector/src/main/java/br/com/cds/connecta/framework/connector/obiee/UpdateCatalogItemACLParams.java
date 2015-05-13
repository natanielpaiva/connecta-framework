
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de UpdateCatalogItemACLParams complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="UpdateCatalogItemACLParams">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://oracle.bi.webservices/v6}UpdateACLParams">
 *       &lt;sequence>
 *         &lt;element name="recursive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateCatalogItemACLParams", propOrder = {
    "recursive"
})
public class UpdateCatalogItemACLParams
    extends UpdateACLParams
{

    protected boolean recursive;

    /**
     * Obtém o valor da propriedade recursive.
     * 
     */
    public boolean isRecursive() {
        return recursive;
    }

    /**
     * Define o valor da propriedade recursive.
     * 
     */
    public void setRecursive(boolean value) {
        this.recursive = value;
    }

}
