
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information about a data domain.
 * 
 * <p>Classe Java de dataDomainDetail complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataDomainDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *         &lt;element name="allowOversubscribe" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowQueriesOnLeader" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numFollowers" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idle" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numComputeThreads" type="{http://www.endeca.com/endeca-server/types/2/0}positiveInt"/>
 *         &lt;element name="computeCacheSizeMB" type="{http://www.endeca.com/endeca-server/types/2/0}positiveInt"/>
 *         &lt;element name="startupTimeoutSeconds" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="shutdownTimeoutSeconds" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="sessionIdType" type="{http://www.endeca.com/endeca-server/types/2/0}sessionIdTypes"/>
 *         &lt;element name="sessionIdKey" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *         &lt;element name="autoIdle" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idleTimeoutMinutes" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="args" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataDomainDetail", propOrder = {
    "name",
    "allowOversubscribe",
    "allowQueriesOnLeader",
    "numFollowers",
    "readOnly",
    "enabled",
    "idle",
    "numComputeThreads",
    "computeCacheSizeMB",
    "startupTimeoutSeconds",
    "shutdownTimeoutSeconds",
    "sessionIdType",
    "sessionIdKey",
    "autoIdle",
    "idleTimeoutMinutes",
    "args"
})
public class DataDomainDetail {

    @XmlElement(required = true)
    protected String name;
    protected boolean allowOversubscribe;
    protected boolean allowQueriesOnLeader;
    protected int numFollowers;
    protected boolean readOnly;
    protected boolean enabled;
    protected boolean idle;
    protected int numComputeThreads;
    protected int computeCacheSizeMB;
    protected int startupTimeoutSeconds;
    protected int shutdownTimeoutSeconds;
    @XmlElement(required = true)
    protected SessionIdTypes sessionIdType;
    @XmlElement(required = true)
    protected String sessionIdKey;
    protected boolean autoIdle;
    protected int idleTimeoutMinutes;
    protected List<String> args;

    /**
     * Obt\u00e9m o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade allowOversubscribe.
     * 
     */
    public boolean isAllowOversubscribe() {
        return allowOversubscribe;
    }

    /**
     * Define o valor da propriedade allowOversubscribe.
     * 
     */
    public void setAllowOversubscribe(boolean value) {
        this.allowOversubscribe = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade allowQueriesOnLeader.
     * 
     */
    public boolean isAllowQueriesOnLeader() {
        return allowQueriesOnLeader;
    }

    /**
     * Define o valor da propriedade allowQueriesOnLeader.
     * 
     */
    public void setAllowQueriesOnLeader(boolean value) {
        this.allowQueriesOnLeader = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numFollowers.
     * 
     */
    public int getNumFollowers() {
        return numFollowers;
    }

    /**
     * Define o valor da propriedade numFollowers.
     * 
     */
    public void setNumFollowers(int value) {
        this.numFollowers = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade readOnly.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Define o valor da propriedade readOnly.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enabled.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Define o valor da propriedade enabled.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade idle.
     * 
     */
    public boolean isIdle() {
        return idle;
    }

    /**
     * Define o valor da propriedade idle.
     * 
     */
    public void setIdle(boolean value) {
        this.idle = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numComputeThreads.
     * 
     */
    public int getNumComputeThreads() {
        return numComputeThreads;
    }

    /**
     * Define o valor da propriedade numComputeThreads.
     * 
     */
    public void setNumComputeThreads(int value) {
        this.numComputeThreads = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade computeCacheSizeMB.
     * 
     */
    public int getComputeCacheSizeMB() {
        return computeCacheSizeMB;
    }

    /**
     * Define o valor da propriedade computeCacheSizeMB.
     * 
     */
    public void setComputeCacheSizeMB(int value) {
        this.computeCacheSizeMB = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade startupTimeoutSeconds.
     * 
     */
    public int getStartupTimeoutSeconds() {
        return startupTimeoutSeconds;
    }

    /**
     * Define o valor da propriedade startupTimeoutSeconds.
     * 
     */
    public void setStartupTimeoutSeconds(int value) {
        this.startupTimeoutSeconds = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade shutdownTimeoutSeconds.
     * 
     */
    public int getShutdownTimeoutSeconds() {
        return shutdownTimeoutSeconds;
    }

    /**
     * Define o valor da propriedade shutdownTimeoutSeconds.
     * 
     */
    public void setShutdownTimeoutSeconds(int value) {
        this.shutdownTimeoutSeconds = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade sessionIdType.
     * 
     * @return
     *     possible object is
     *     {@link SessionIdTypes }
     *     
     */
    public SessionIdTypes getSessionIdType() {
        return sessionIdType;
    }

    /**
     * Define o valor da propriedade sessionIdType.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionIdTypes }
     *     
     */
    public void setSessionIdType(SessionIdTypes value) {
        this.sessionIdType = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade sessionIdKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionIdKey() {
        return sessionIdKey;
    }

    /**
     * Define o valor da propriedade sessionIdKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionIdKey(String value) {
        this.sessionIdKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade autoIdle.
     * 
     */
    public boolean isAutoIdle() {
        return autoIdle;
    }

    /**
     * Define o valor da propriedade autoIdle.
     * 
     */
    public void setAutoIdle(boolean value) {
        this.autoIdle = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade idleTimeoutMinutes.
     * 
     */
    public int getIdleTimeoutMinutes() {
        return idleTimeoutMinutes;
    }

    /**
     * Define o valor da propriedade idleTimeoutMinutes.
     * 
     */
    public void setIdleTimeoutMinutes(int value) {
        this.idleTimeoutMinutes = value;
    }

    /**
     * Gets the value of the args property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the args property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArgs() {
        if (args == null) {
            args = new ArrayList<String>();
        }
        return this.args;
    }

}
