
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ExpressionBase complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ExpressionBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressionBase")
@XmlSeeAlso({
    SetEmptinessExpression.class,
    MembersOfExpression.class,
    InExpression.class,
    NullnessExpression.class,
    AndExpression.class,
    ComparisonExpression.class,
    SetConstructor.class,
    UniversalQuantifierExpression.class,
    AttributeRefExpression.class,
    BetweenExpression.class,
    AdditiveExpression.class,
    MultiplicativeExpression.class,
    FunctionCallExpression.class,
    OrExpression.class,
    SetMembershipExpression.class,
    LookupExpression.class,
    NotExpression.class,
    CaseExpression.class,
    StringLiteral.class,
    ExistentialQuantifierExpression.class,
    ConstantKeyword.class,
    IntegerLiteral.class,
    DoubleLiteral.class,
    BooleanLiteral.class
})
public abstract class ExpressionBase
    extends Node
{


}
