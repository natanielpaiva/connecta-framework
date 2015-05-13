
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CrossJoin complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CrossJoin">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}SourceBase">
 *       &lt;sequence>
 *         &lt;element name="leftChild" type="{http://www.endeca.com/MDEX/eql_parser/types}SourceBase"/>
 *         &lt;element name="rightChild" type="{http://www.endeca.com/MDEX/eql_parser/types}SourceBase"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrossJoin", propOrder = {
    "leftChild",
    "rightChild"
})
public class CrossJoin
    extends SourceBase
{

    @XmlElement(required = true)
    protected SourceBase leftChild;
    @XmlElement(required = true)
    protected SourceBase rightChild;

    /**
     * Obt\u00e9m o valor da propriedade leftChild.
     * 
     * @return
     *     possible object is
     *     {@link SourceBase }
     *     
     */
    public SourceBase getLeftChild() {
        return leftChild;
    }

    /**
     * Define o valor da propriedade leftChild.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceBase }
     *     
     */
    public void setLeftChild(SourceBase value) {
        this.leftChild = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade rightChild.
     * 
     * @return
     *     possible object is
     *     {@link SourceBase }
     *     
     */
    public SourceBase getRightChild() {
        return rightChild;
    }

    /**
     * Define o valor da propriedade rightChild.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceBase }
     *     
     */
    public void setRightChild(SourceBase value) {
        this.rightChild = value;
    }

}
