
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Node complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Node">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Node")
@XmlSeeAlso({
    CaseClause.class,
    OrderByList.class,
    Group.class,
    Where.class,
    StatementAlias.class,
    StateFilter.class,
    Having.class,
    ElseClause.class,
    OrderBy.class,
    StatementQualifier.class,
    MetaVariable.class,
    Select.class,
    GroupingSets.class,
    StandaloneFilter.class,
    Query.class,
    Statement.class,
    Direction.class,
    PageBase.class,
    GroupSetBase.class,
    From.class,
    GroupingKeyBase.class,
    SourceBase.class,
    ExpressionBase.class
})
public abstract class Node {


}
