
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.Account;
import br.com.cds.connecta.framework.connector.obiee.ACL;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.0
 * 
 */
@WebService(name = "SecurityServiceSoap", targetNamespace = "urn://oracle.bi.webservices/v6")
public interface SecurityServiceSoap {


    /**
     * 
     * @param sessionID
     * @return
     *     returns java.util.List<oracle.bi.web.soap.Privilege>
     */
    @WebMethod(action = "#getGlobalPrivileges")
    @WebResult(name = "sawPrivileges", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getGlobalPrivileges", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGlobalPrivileges")
    @ResponseWrapper(localName = "getGlobalPrivilegesResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGlobalPrivilegesResult")
    public List<Privilege> getGlobalPrivileges(
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param privilegeName
     * @return
     *     returns oracle.bi.web.soap.ACL
     */
    @WebMethod(action = "#getGlobalPrivilegeACL")
    @WebResult(name = "acl", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getGlobalPrivilegeACL", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGlobalPrivilegeACL")
    @ResponseWrapper(localName = "getGlobalPrivilegeACLResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGlobalPrivilegeACLResult")
    public ACL getGlobalPrivilegeACL(
        @WebParam(name = "privilegeName", targetNamespace = "urn://oracle.bi.webservices/v6")
        String privilegeName,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param acl
     * @param updateACLParams
     * @param privilegeName
     */
    @WebMethod(action = "#updateGlobalPrivilegeACL")
    @RequestWrapper(localName = "updateGlobalPrivilegeACL", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.UpdateGlobalPrivilegeACL")
    @ResponseWrapper(localName = "updateGlobalPrivilegeACLResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.UpdateGlobalPrivilegeACLResult")
    public void updateGlobalPrivilegeACL(
        @WebParam(name = "privilegeName", targetNamespace = "urn://oracle.bi.webservices/v6")
        String privilegeName,
        @WebParam(name = "acl", targetNamespace = "urn://oracle.bi.webservices/v6")
        ACL acl,
        @WebParam(name = "updateACLParams", targetNamespace = "urn://oracle.bi.webservices/v6")
        UpdateACLParams updateACLParams,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param cleanuplevel
     * @param sessionID
     * @param account
     */
    @WebMethod(action = "#forgetAccounts")
    @RequestWrapper(localName = "forgetAccounts", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ForgetAccounts")
    @ResponseWrapper(localName = "forgetAccountsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ForgetAccountsResult")
    public void forgetAccounts(
        @WebParam(name = "account", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> account,
        @WebParam(name = "cleanuplevel", targetNamespace = "urn://oracle.bi.webservices/v6")
        int cleanuplevel,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param to
     * @param sessionID
     * @param from
     */
    @WebMethod(action = "#renameAccounts")
    @RequestWrapper(localName = "renameAccounts", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.RenameAccounts")
    @ResponseWrapper(localName = "renameAccountsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.RenameAccountsResult")
    public void renameAccounts(
        @WebParam(name = "from", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> from,
        @WebParam(name = "to", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> to,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param member
     * @param sessionID
     * @param group
     */
    @WebMethod(action = "#joinGroups")
    @RequestWrapper(localName = "joinGroups", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.JoinGroups")
    @ResponseWrapper(localName = "joinGroupsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.JoinGroupsResult")
    public void joinGroups(
        @WebParam(name = "group", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> group,
        @WebParam(name = "member", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> member,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param member
     * @param sessionID
     * @param group
     */
    @WebMethod(action = "#leaveGroups")
    @RequestWrapper(localName = "leaveGroups", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.LeaveGroups")
    @ResponseWrapper(localName = "leaveGroupsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.LeaveGroupsResult")
    public void leaveGroups(
        @WebParam(name = "group", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> group,
        @WebParam(name = "member", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> member,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param member
     * @param sessionID
     * @param expandGroups
     * @return
     *     returns java.util.List<oracle.bi.web.soap.Account>
     */
    @WebMethod(action = "#getGroups")
    @WebResult(name = "account", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getGroups", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGroups")
    @ResponseWrapper(localName = "getGroupsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetGroupsResult")
    public List<Account> getGroups(
        @WebParam(name = "member", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> member,
        @WebParam(name = "expandGroups", targetNamespace = "urn://oracle.bi.webservices/v6")
        Boolean expandGroups,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param expandGroups
     * @param group
     * @return
     *     returns java.util.List<oracle.bi.web.soap.Account>
     */
    @WebMethod(action = "#getMembers")
    @WebResult(name = "account", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getMembers", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetMembers")
    @ResponseWrapper(localName = "getMembersResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetMembersResult")
    public List<Account> getMembers(
        @WebParam(name = "group", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> group,
        @WebParam(name = "expandGroups", targetNamespace = "urn://oracle.bi.webservices/v6")
        Boolean expandGroups,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param member
     * @param sessionID
     * @param expandGroups
     * @param group
     * @return
     *     returns boolean
     */
    @WebMethod(action = "#isMember")
    @WebResult(name = "result", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "isMember", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.IsMember")
    @ResponseWrapper(localName = "isMemberResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.IsMemberResult")
    public boolean isMember(
        @WebParam(name = "group", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> group,
        @WebParam(name = "member", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> member,
        @WebParam(name = "expandGroups", targetNamespace = "urn://oracle.bi.webservices/v6")
        Boolean expandGroups,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param account
     * @param acls
     * @return
     *     returns java.util.List<java.lang.Integer>
     */
    @WebMethod(action = "#getPermissions")
    @WebResult(targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getPermissions", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetPermissions")
    @ResponseWrapper(localName = "getPermissionsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetPermissionsResult")
    public List<Integer> getPermissions(
        @WebParam(name = "acls", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<ACL> acls,
        @WebParam(name = "account", targetNamespace = "urn://oracle.bi.webservices/v6")
        Account account,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param privileges
     * @return
     *     returns java.util.List<java.lang.Boolean>
     */
    @WebMethod(action = "#getPrivilegesStatus")
    @WebResult(targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getPrivilegesStatus", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetPrivilegesStatus")
    @ResponseWrapper(localName = "getPrivilegesStatusResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetPrivilegesStatusResult")
    public List<Boolean> getPrivilegesStatus(
        @WebParam(name = "privileges", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<String> privileges,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param account
     * @return
     *     returns java.util.List<oracle.bi.web.soap.Account>
     */
    @WebMethod(action = "#getAccounts")
    @WebResult(name = "accountDetails", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "getAccounts", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetAccounts")
    @ResponseWrapper(localName = "getAccountsResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.GetAccountsResult")
    public List<Account> getAccounts(
        @WebParam(name = "account", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<Account> account,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

}
