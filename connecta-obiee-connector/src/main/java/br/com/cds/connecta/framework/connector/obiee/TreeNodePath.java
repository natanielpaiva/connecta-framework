
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TreeNodePath complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TreeNodePath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="treePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="treeNode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TreeNodePath", propOrder = {
    "treePath",
    "treeNode"
})
public class TreeNodePath {

    @XmlElement(required = true)
    protected String treePath;
    @XmlElement(required = true)
    protected String treeNode;

    /**
     * Obtém o valor da propriedade treePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * Define o valor da propriedade treePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreePath(String value) {
        this.treePath = value;
    }

    /**
     * Obtém o valor da propriedade treeNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreeNode() {
        return treeNode;
    }

    /**
     * Define o valor da propriedade treeNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreeNode(String value) {
        this.treeNode = value;
    }

}
