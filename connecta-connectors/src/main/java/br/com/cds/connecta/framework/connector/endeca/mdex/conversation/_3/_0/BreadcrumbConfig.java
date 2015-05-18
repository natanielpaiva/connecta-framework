
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The BreadcrumbConfig type contains the inputs needed to generate a Breadcrumb result component.
 * 						If ReturnFullPath is set to true, each selected dimension value will be accompanied by a list of
 * 						dimension values that represents its path to root.
 * 
 * <p>Classe Java de BreadcrumbConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="BreadcrumbConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;attribute name="ReturnFullPath" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BreadcrumbConfig")
public class BreadcrumbConfig
    extends ContentElementConfig
{

    @XmlAttribute(name = "ReturnFullPath")
    protected Boolean returnFullPath;

    /**
     * Obt\u00e9m o valor da propriedade returnFullPath.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnFullPath() {
        if (returnFullPath == null) {
            return true;
        } else {
            return returnFullPath;
        }
    }

    /**
     * Define o valor da propriedade returnFullPath.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnFullPath(Boolean value) {
        this.returnFullPath = value;
    }

}
