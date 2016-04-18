
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.GetCounts;
import br.com.cds.connecta.framework.connector.obiee.GetGroups;
import br.com.cds.connecta.framework.connector.obiee.GetMembers;
import br.com.cds.connecta.framework.connector.obiee.GetSessionEnvironment;
import br.com.cds.connecta.framework.connector.obiee.GetHtmlForPageWithOneReport;
import br.com.cds.connecta.framework.connector.obiee.GetPrivilegesStatusResult;
import br.com.cds.connecta.framework.connector.obiee.GetItemInfoResult;
import br.com.cds.connecta.framework.connector.obiee.GetPermissionsResult;
import br.com.cds.connecta.framework.connector.obiee.GetCountsResult;
import br.com.cds.connecta.framework.connector.obiee.GetJobInfoResult;
import br.com.cds.connecta.framework.connector.obiee.GetSessionVariables;
import br.com.cds.connecta.framework.connector.obiee.GetGlobalPrivileges;
import br.com.cds.connecta.framework.connector.obiee.GetPromptedColumnsResult;
import br.com.cds.connecta.framework.connector.obiee.GetCommonBodyHtml;
import br.com.cds.connecta.framework.connector.obiee.GetCurUserResult;
import br.com.cds.connecta.framework.connector.obiee.GetGlobalPrivilegeACL;
import br.com.cds.connecta.framework.connector.obiee.GetMembersResult;
import br.com.cds.connecta.framework.connector.obiee.GetPromptedFiltersResult;
import br.com.cds.connecta.framework.connector.obiee.GetCurUser;
import br.com.cds.connecta.framework.connector.obiee.GetGlobalPrivilegesResult;
import br.com.cds.connecta.framework.connector.obiee.GetGlobalPrivilegeACLResult;
import br.com.cds.connecta.framework.connector.obiee.GetSubItems;
import br.com.cds.connecta.framework.connector.obiee.GetHeadersHtmlResult;
import br.com.cds.connecta.framework.connector.obiee.GetGroupsResult;
import br.com.cds.connecta.framework.connector.obiee.GetHtmlForPageWithOneReportResult;
import br.com.cds.connecta.framework.connector.obiee.GetPrivilegesStatus;
import br.com.cds.connecta.framework.connector.obiee.GetHtmlForReportResult;
import br.com.cds.connecta.framework.connector.obiee.GetConditionCustomizableReportElements;
import br.com.cds.connecta.framework.connector.obiee.GetHeadersHtml;
import br.com.cds.connecta.framework.connector.obiee.GetPromptedColumns;
import br.com.cds.connecta.framework.connector.obiee.GetItemInfo;
import br.com.cds.connecta.framework.connector.obiee.GetJobInfo;
import br.com.cds.connecta.framework.connector.obiee.GetPermissions;
import br.com.cds.connecta.framework.connector.obiee.GetPromptedFilters;
import br.com.cds.connecta.framework.connector.obiee.GetConditionCustomizableReportElementsResult;
import br.com.cds.connecta.framework.connector.obiee.GetSessionEnvironmentResult;
import br.com.cds.connecta.framework.connector.obiee.GetHtmlForReport;
import br.com.cds.connecta.framework.connector.obiee.GetCommonBodyHtmlResult;
import br.com.cds.connecta.framework.connector.obiee.GetSessionVariablesResult;
import br.com.cds.connecta.framework.connector.obiee.DescribeSubjectArea;
import br.com.cds.connecta.framework.connector.obiee.EvaluateInlineCondition;
import br.com.cds.connecta.framework.connector.obiee.EvaluateCondition;
import br.com.cds.connecta.framework.connector.obiee.ErrorInfo;
import br.com.cds.connecta.framework.connector.obiee.EvaluateConditionResult;
import br.com.cds.connecta.framework.connector.obiee.EndPage;
import br.com.cds.connecta.framework.connector.obiee.DescribeTableResult;
import br.com.cds.connecta.framework.connector.obiee.EvaluateInlineConditionResult;
import br.com.cds.connecta.framework.connector.obiee.DescribeTable;
import br.com.cds.connecta.framework.connector.obiee.DescribeSubjectAreaResult;
import br.com.cds.connecta.framework.connector.obiee.EndPageResult;
import br.com.cds.connecta.framework.connector.obiee.DeleteIBotResult;
import br.com.cds.connecta.framework.connector.obiee.CreateFolder;
import br.com.cds.connecta.framework.connector.obiee.CopyItem2Result;
import br.com.cds.connecta.framework.connector.obiee.DescribeColumnResult;
import br.com.cds.connecta.framework.connector.obiee.CreateLinkResult;
import br.com.cds.connecta.framework.connector.obiee.DeleteIBot;
import br.com.cds.connecta.framework.connector.obiee.CreateLink;
import br.com.cds.connecta.framework.connector.obiee.DeleteItemResult;
import br.com.cds.connecta.framework.connector.obiee.CopyItemResult;
import br.com.cds.connecta.framework.connector.obiee.CopyItem2;
import br.com.cds.connecta.framework.connector.obiee.DescribeColumn;
import br.com.cds.connecta.framework.connector.obiee.ClearQueryCacheResult;
import br.com.cds.connecta.framework.connector.obiee.DeleteResultSetResult;
import br.com.cds.connecta.framework.connector.obiee.DeleteResultSet;
import br.com.cds.connecta.framework.connector.obiee.CreateFolderResult;
import br.com.cds.connecta.framework.connector.obiee.CopyItem;
import br.com.cds.connecta.framework.connector.obiee.DeleteItem;
import br.com.cds.connecta.framework.connector.obiee.AddReportToPage;
import br.com.cds.connecta.framework.connector.obiee.ApplyReportDefaultsResult;
import br.com.cds.connecta.framework.connector.obiee.AddReportToPageResult;
import br.com.cds.connecta.framework.connector.obiee.CatalogItemsFilter;
import br.com.cds.connecta.framework.connector.obiee.ClearQueryCache;
import br.com.cds.connecta.framework.connector.obiee.CancelQueryResult;
import br.com.cds.connecta.framework.connector.obiee.Account;
import br.com.cds.connecta.framework.connector.obiee.ApplyReportDefaults;
import br.com.cds.connecta.framework.connector.obiee.AccessControlToken;
import br.com.cds.connecta.framework.connector.obiee.CancelQuery;
import br.com.cds.connecta.framework.connector.obiee.ACL;
import br.com.cds.connecta.framework.connector.obiee.ArrayOfGUIDs;
import br.com.cds.connecta.framework.connector.obiee.ApplyReportParamsResult;
import br.com.cds.connecta.framework.connector.obiee.AuthResult;
import br.com.cds.connecta.framework.connector.obiee.CatalogObject;
import br.com.cds.connecta.framework.connector.obiee.ApplyReportParams;
import br.com.cds.connecta.framework.connector.obiee.CancelJobResult;
import br.com.cds.connecta.framework.connector.obiee.CancelJob;
import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.bi.web.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.bi.web.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JobInfo }
     * 
     */
    public JobInfo createJobInfo() {
        return new JobInfo();
    }

    /**
     * Create an instance of {@link CopyItem2 }
     * 
     */
    public CopyItem2 createCopyItem2() {
        return new CopyItem2();
    }

    /**
     * Create an instance of {@link PasteItem2 }
     * 
     */
    public PasteItem2 createPasteItem2() {
        return new PasteItem2();
    }

    /**
     * Create an instance of {@link ExecuteSQLQueryResult }
     * 
     */
    public ExecuteSQLQueryResult createExecuteSQLQueryResult() {
        return new ExecuteSQLQueryResult();
    }

    /**
     * Create an instance of {@link QueryResults }
     * 
     */
    public QueryResults createQueryResults() {
        return new QueryResults();
    }

    /**
     * Create an instance of {@link PurgeCache }
     * 
     */
    public PurgeCache createPurgeCache() {
        return new PurgeCache();
    }

    /**
     * Create an instance of {@link GetJobInfo }
     * 
     */
    public GetJobInfo createGetJobInfo() {
        return new GetJobInfo();
    }

    /**
     * Create an instance of {@link GetCurUser }
     * 
     */
    public GetCurUser createGetCurUser() {
        return new GetCurUser();
    }

    /**
     * Create an instance of {@link MoveItem }
     * 
     */
    public MoveItem createMoveItem() {
        return new MoveItem();
    }

    /**
     * Create an instance of {@link Logonex }
     * 
     */
    public Logonex createLogonex() {
        return new Logonex();
    }

    /**
     * Create an instance of {@link SAWSessionParameters }
     * 
     */
    public SAWSessionParameters createSAWSessionParameters() {
        return new SAWSessionParameters();
    }

    /**
     * Create an instance of {@link DeleteResultSet }
     * 
     */
    public DeleteResultSet createDeleteResultSet() {
        return new DeleteResultSet();
    }

    /**
     * Create an instance of {@link ArrayOfGUIDs }
     * 
     */
    public ArrayOfGUIDs createArrayOfGUIDs() {
        return new ArrayOfGUIDs();
    }

    /**
     * Create an instance of {@link LeaveGroupsResult }
     * 
     */
    public LeaveGroupsResult createLeaveGroupsResult() {
        return new LeaveGroupsResult();
    }

    /**
     * Create an instance of {@link CreateFolder }
     * 
     */
    public CreateFolder createCreateFolder() {
        return new CreateFolder();
    }

    /**
     * Create an instance of {@link StartPage }
     * 
     */
    public StartPage createStartPage() {
        return new StartPage();
    }

    /**
     * Create an instance of {@link StartPageParams }
     * 
     */
    public StartPageParams createStartPageParams() {
        return new StartPageParams();
    }

    /**
     * Create an instance of {@link GetPromptedColumns }
     * 
     */
    public GetPromptedColumns createGetPromptedColumns() {
        return new GetPromptedColumns();
    }

    /**
     * Create an instance of {@link GenerateReportSQL }
     * 
     */
    public GenerateReportSQL createGenerateReportSQL() {
        return new GenerateReportSQL();
    }

    /**
     * Create an instance of {@link ReportRef }
     * 
     */
    public ReportRef createReportRef() {
        return new ReportRef();
    }

    /**
     * Create an instance of {@link ReportParams }
     * 
     */
    public ReportParams createReportParams() {
        return new ReportParams();
    }

    /**
     * Create an instance of {@link IsMemberResult }
     * 
     */
    public IsMemberResult createIsMemberResult() {
        return new IsMemberResult();
    }

    /**
     * Create an instance of {@link PurgeLogResult }
     * 
     */
    public PurgeLogResult createPurgeLogResult() {
        return new PurgeLogResult();
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link ForgetAccountsResult }
     * 
     */
    public ForgetAccountsResult createForgetAccountsResult() {
        return new ForgetAccountsResult();
    }

    /**
     * Create an instance of {@link GetPermissions }
     * 
     */
    public GetPermissions createGetPermissions() {
        return new GetPermissions();
    }

    /**
     * Create an instance of {@link ACL }
     * 
     */
    public ACL createACL() {
        return new ACL();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link DescribeSubjectAreaResult }
     * 
     */
    public DescribeSubjectAreaResult createDescribeSubjectAreaResult() {
        return new DescribeSubjectAreaResult();
    }

    /**
     * Create an instance of {@link SASubjectArea }
     * 
     */
    public SASubjectArea createSASubjectArea() {
        return new SASubjectArea();
    }

    /**
     * Create an instance of {@link DeleteItem }
     * 
     */
    public DeleteItem createDeleteItem() {
        return new DeleteItem();
    }

    /**
     * Create an instance of {@link GetSessionVariables }
     * 
     */
    public GetSessionVariables createGetSessionVariables() {
        return new GetSessionVariables();
    }

    /**
     * Create an instance of {@link Import }
     * 
     */
    public Import createImport() {
        return new Import();
    }

    /**
     * Create an instance of {@link CatalogItemsFilter }
     * 
     */
    public CatalogItemsFilter createCatalogItemsFilter() {
        return new CatalogItemsFilter();
    }

    /**
     * Create an instance of {@link PathMap }
     * 
     */
    public PathMap createPathMap() {
        return new PathMap();
    }

    /**
     * Create an instance of {@link GetHtmlForReportResult }
     * 
     */
    public GetHtmlForReportResult createGetHtmlForReportResult() {
        return new GetHtmlForReportResult();
    }

    /**
     * Create an instance of {@link Logon }
     * 
     */
    public Logon createLogon() {
        return new Logon();
    }

    /**
     * Create an instance of {@link WriteListFiles }
     * 
     */
    public WriteListFiles createWriteListFiles() {
        return new WriteListFiles();
    }

    /**
     * Create an instance of {@link TreeNodePath }
     * 
     */
    public TreeNodePath createTreeNodePath() {
        return new TreeNodePath();
    }

    /**
     * Create an instance of {@link SegmentationOptions }
     * 
     */
    public SegmentationOptions createSegmentationOptions() {
        return new SegmentationOptions();
    }

    /**
     * Create an instance of {@link AddReportToPage }
     * 
     */
    public AddReportToPage createAddReportToPage() {
        return new AddReportToPage();
    }

    /**
     * Create an instance of {@link ReportHTMLOptions }
     * 
     */
    public ReportHTMLOptions createReportHTMLOptions() {
        return new ReportHTMLOptions();
    }

    /**
     * Create an instance of {@link RenameAccountsResult }
     * 
     */
    public RenameAccountsResult createRenameAccountsResult() {
        return new RenameAccountsResult();
    }

    /**
     * Create an instance of {@link DeleteResultSetResult }
     * 
     */
    public DeleteResultSetResult createDeleteResultSetResult() {
        return new DeleteResultSetResult();
    }

    /**
     * Create an instance of {@link KeepAliveResult }
     * 
     */
    public KeepAliveResult createKeepAliveResult() {
        return new KeepAliveResult();
    }

    /**
     * Create an instance of {@link SetBridge }
     * 
     */
    public SetBridge createSetBridge() {
        return new SetBridge();
    }

    /**
     * Create an instance of {@link GetHtmlForReport }
     * 
     */
    public GetHtmlForReport createGetHtmlForReport() {
        return new GetHtmlForReport();
    }

    /**
     * Create an instance of {@link GetGroups }
     * 
     */
    public GetGroups createGetGroups() {
        return new GetGroups();
    }

    /**
     * Create an instance of {@link CancelJobResult }
     * 
     */
    public CancelJobResult createCancelJobResult() {
        return new CancelJobResult();
    }

    /**
     * Create an instance of {@link MaintenanceModeResult }
     * 
     */
    public MaintenanceModeResult createMaintenanceModeResult() {
        return new MaintenanceModeResult();
    }

    /**
     * Create an instance of {@link CancelQuery }
     * 
     */
    public CancelQuery createCancelQuery() {
        return new CancelQuery();
    }

    /**
     * Create an instance of {@link EvaluateInlineConditionResult }
     * 
     */
    public EvaluateInlineConditionResult createEvaluateInlineConditionResult() {
        return new EvaluateInlineConditionResult();
    }

    /**
     * Create an instance of {@link GetGlobalPrivilegeACL }
     * 
     */
    public GetGlobalPrivilegeACL createGetGlobalPrivilegeACL() {
        return new GetGlobalPrivilegeACL();
    }

    /**
     * Create an instance of {@link LogonResult }
     * 
     */
    public LogonResult createLogonResult() {
        return new LogonResult();
    }

    /**
     * Create an instance of {@link GetGroupsResult }
     * 
     */
    public GetGroupsResult createGetGroupsResult() {
        return new GetGroupsResult();
    }

    /**
     * Create an instance of {@link CreateFolderResult }
     * 
     */
    public CreateFolderResult createCreateFolderResult() {
        return new CreateFolderResult();
    }

    /**
     * Create an instance of {@link WriteObjects }
     * 
     */
    public WriteObjects createWriteObjects() {
        return new WriteObjects();
    }

    /**
     * Create an instance of {@link CatalogObject }
     * 
     */
    public CatalogObject createCatalogObject() {
        return new CatalogObject();
    }

    /**
     * Create an instance of {@link RenameAccounts }
     * 
     */
    public RenameAccounts createRenameAccounts() {
        return new RenameAccounts();
    }

    /**
     * Create an instance of {@link LeaveGroups }
     * 
     */
    public LeaveGroups createLeaveGroups() {
        return new LeaveGroups();
    }

    /**
     * Create an instance of {@link IsMember }
     * 
     */
    public IsMember createIsMember() {
        return new IsMember();
    }

    /**
     * Create an instance of {@link Logoff }
     * 
     */
    public Logoff createLogoff() {
        return new Logoff();
    }

    /**
     * Create an instance of {@link JoinGroupsResult }
     * 
     */
    public JoinGroupsResult createJoinGroupsResult() {
        return new JoinGroupsResult();
    }

    /**
     * Create an instance of {@link SetOwnership }
     * 
     */
    public SetOwnership createSetOwnership() {
        return new SetOwnership();
    }

    /**
     * Create an instance of {@link DeleteItemResult }
     * 
     */
    public DeleteItemResult createDeleteItemResult() {
        return new DeleteItemResult();
    }

    /**
     * Create an instance of {@link PrepareCache }
     * 
     */
    public PrepareCache createPrepareCache() {
        return new PrepareCache();
    }

    /**
     * Create an instance of {@link GetItemInfo }
     * 
     */
    public GetItemInfo createGetItemInfo() {
        return new GetItemInfo();
    }

    /**
     * Create an instance of {@link SendMessageResult }
     * 
     */
    public SendMessageResult createSendMessageResult() {
        return new SendMessageResult();
    }

    /**
     * Create an instance of {@link GetPrivilegesStatusResult }
     * 
     */
    public GetPrivilegesStatusResult createGetPrivilegesStatusResult() {
        return new GetPrivilegesStatusResult();
    }

    /**
     * Create an instance of {@link EvaluateInlineCondition }
     * 
     */
    public EvaluateInlineCondition createEvaluateInlineCondition() {
        return new EvaluateInlineCondition();
    }

    /**
     * Create an instance of {@link CancelJob }
     * 
     */
    public CancelJob createCancelJob() {
        return new CancelJob();
    }

    /**
     * Create an instance of {@link AddReportToPageResult }
     * 
     */
    public AddReportToPageResult createAddReportToPageResult() {
        return new AddReportToPageResult();
    }

    /**
     * Create an instance of {@link EndPageResult }
     * 
     */
    public EndPageResult createEndPageResult() {
        return new EndPageResult();
    }

    /**
     * Create an instance of {@link GetPromptedFiltersResult }
     * 
     */
    public GetPromptedFiltersResult createGetPromptedFiltersResult() {
        return new GetPromptedFiltersResult();
    }

    /**
     * Create an instance of {@link Impersonate }
     * 
     */
    public Impersonate createImpersonate() {
        return new Impersonate();
    }

    /**
     * Create an instance of {@link Subscribe }
     * 
     */
    public Subscribe createSubscribe() {
        return new Subscribe();
    }

    /**
     * Create an instance of {@link DeleteIBotResult }
     * 
     */
    public DeleteIBotResult createDeleteIBotResult() {
        return new DeleteIBotResult();
    }

    /**
     * Create an instance of {@link ForgetAccounts }
     * 
     */
    public ForgetAccounts createForgetAccounts() {
        return new ForgetAccounts();
    }

    /**
     * Create an instance of {@link GetItemInfoResult }
     * 
     */
    public GetItemInfoResult createGetItemInfoResult() {
        return new GetItemInfoResult();
    }

    /**
     * Create an instance of {@link ItemInfo }
     * 
     */
    public ItemInfo createItemInfo() {
        return new ItemInfo();
    }

    /**
     * Create an instance of {@link DescribeColumnResult }
     * 
     */
    public DescribeColumnResult createDescribeColumnResult() {
        return new DescribeColumnResult();
    }

    /**
     * Create an instance of {@link SAColumn }
     * 
     */
    public SAColumn createSAColumn() {
        return new SAColumn();
    }

    /**
     * Create an instance of {@link UpdateCatalogItemACL }
     * 
     */
    public UpdateCatalogItemACL createUpdateCatalogItemACL() {
        return new UpdateCatalogItemACL();
    }

    /**
     * Create an instance of {@link UpdateCatalogItemACLParams }
     * 
     */
    public UpdateCatalogItemACLParams createUpdateCatalogItemACLParams() {
        return new UpdateCatalogItemACLParams();
    }

    /**
     * Create an instance of {@link FetchNextResult }
     * 
     */
    public FetchNextResult createFetchNextResult() {
        return new FetchNextResult();
    }

    /**
     * Create an instance of {@link WriteListFilesResult }
     * 
     */
    public WriteListFilesResult createWriteListFilesResult() {
        return new WriteListFilesResult();
    }

    /**
     * Create an instance of {@link StartPageResult }
     * 
     */
    public StartPageResult createStartPageResult() {
        return new StartPageResult();
    }

    /**
     * Create an instance of {@link SetItemPropertyResult }
     * 
     */
    public SetItemPropertyResult createSetItemPropertyResult() {
        return new SetItemPropertyResult();
    }

    /**
     * Create an instance of {@link WriteObjectsResult }
     * 
     */
    public WriteObjectsResult createWriteObjectsResult() {
        return new WriteObjectsResult();
    }

    /**
     * Create an instance of {@link ErrorInfo }
     * 
     */
    public ErrorInfo createErrorInfo() {
        return new ErrorInfo();
    }

    /**
     * Create an instance of {@link PrepareCacheResult }
     * 
     */
    public PrepareCacheResult createPrepareCacheResult() {
        return new PrepareCacheResult();
    }

    /**
     * Create an instance of {@link SetItemAttributes }
     * 
     */
    public SetItemAttributes createSetItemAttributes() {
        return new SetItemAttributes();
    }

    /**
     * Create an instance of {@link ImportResult }
     * 
     */
    public ImportResult createImportResult() {
        return new ImportResult();
    }

    /**
     * Create an instance of {@link ImportError }
     * 
     */
    public ImportError createImportError() {
        return new ImportError();
    }

    /**
     * Create an instance of {@link GetHeadersHtmlResult }
     * 
     */
    public GetHeadersHtmlResult createGetHeadersHtmlResult() {
        return new GetHeadersHtmlResult();
    }

    /**
     * Create an instance of {@link GetAccountsResult }
     * 
     */
    public GetAccountsResult createGetAccountsResult() {
        return new GetAccountsResult();
    }

    /**
     * Create an instance of {@link MarkForReplicationResult }
     * 
     */
    public MarkForReplicationResult createMarkForReplicationResult() {
        return new MarkForReplicationResult();
    }

    /**
     * Create an instance of {@link LogoffResult }
     * 
     */
    public LogoffResult createLogoffResult() {
        return new LogoffResult();
    }

    /**
     * Create an instance of {@link DeleteIBot }
     * 
     */
    public DeleteIBot createDeleteIBot() {
        return new DeleteIBot();
    }

    /**
     * Create an instance of {@link ReadObjects }
     * 
     */
    public ReadObjects createReadObjects() {
        return new ReadObjects();
    }

    /**
     * Create an instance of {@link GetHeadersHtml }
     * 
     */
    public GetHeadersHtml createGetHeadersHtml() {
        return new GetHeadersHtml();
    }

    /**
     * Create an instance of {@link CopyItem }
     * 
     */
    public CopyItem createCopyItem() {
        return new CopyItem();
    }

    /**
     * Create an instance of {@link MoveItemResult }
     * 
     */
    public MoveItemResult createMoveItemResult() {
        return new MoveItemResult();
    }

    /**
     * Create an instance of {@link EvaluateCondition }
     * 
     */
    public EvaluateCondition createEvaluateCondition() {
        return new EvaluateCondition();
    }

    /**
     * Create an instance of {@link PasteItem2Result }
     * 
     */
    public PasteItem2Result createPasteItem2Result() {
        return new PasteItem2Result();
    }

    /**
     * Create an instance of {@link GetConditionCustomizableReportElements }
     * 
     */
    public GetConditionCustomizableReportElements createGetConditionCustomizableReportElements() {
        return new GetConditionCustomizableReportElements();
    }

    /**
     * Create an instance of {@link GetGlobalPrivileges }
     * 
     */
    public GetGlobalPrivileges createGetGlobalPrivileges() {
        return new GetGlobalPrivileges();
    }

    /**
     * Create an instance of {@link GetSubjectAreasResult }
     * 
     */
    public GetSubjectAreasResult createGetSubjectAreasResult() {
        return new GetSubjectAreasResult();
    }

    /**
     * Create an instance of {@link ApplyReportDefaultsResult }
     * 
     */
    public ApplyReportDefaultsResult createApplyReportDefaultsResult() {
        return new ApplyReportDefaultsResult();
    }

    /**
     * Create an instance of {@link FetchNext }
     * 
     */
    public FetchNext createFetchNext() {
        return new FetchNext();
    }

    /**
     * Create an instance of {@link SaveResultSetResult }
     * 
     */
    public SaveResultSetResult createSaveResultSetResult() {
        return new SaveResultSetResult();
    }

    /**
     * Create an instance of {@link GetJobInfoResult }
     * 
     */
    public GetJobInfoResult createGetJobInfoResult() {
        return new GetJobInfoResult();
    }

    /**
     * Create an instance of {@link UpdateGlobalPrivilegeACLResult }
     * 
     */
    public UpdateGlobalPrivilegeACLResult createUpdateGlobalPrivilegeACLResult() {
        return new UpdateGlobalPrivilegeACLResult();
    }

    /**
     * Create an instance of {@link ImpersonateexResult }
     * 
     */
    public ImpersonateexResult createImpersonateexResult() {
        return new ImpersonateexResult();
    }

    /**
     * Create an instance of {@link AuthResult }
     * 
     */
    public AuthResult createAuthResult() {
        return new AuthResult();
    }

    /**
     * Create an instance of {@link SetOwnershipResult }
     * 
     */
    public SetOwnershipResult createSetOwnershipResult() {
        return new SetOwnershipResult();
    }

    /**
     * Create an instance of {@link GetCounts }
     * 
     */
    public GetCounts createGetCounts() {
        return new GetCounts();
    }

    /**
     * Create an instance of {@link GetSubItemsResult }
     * 
     */
    public GetSubItemsResult createGetSubItemsResult() {
        return new GetSubItemsResult();
    }

    /**
     * Create an instance of {@link MarkForReplication }
     * 
     */
    public MarkForReplication createMarkForReplication() {
        return new MarkForReplication();
    }

    /**
     * Create an instance of {@link MaintenanceMode }
     * 
     */
    public MaintenanceMode createMaintenanceMode() {
        return new MaintenanceMode();
    }

    /**
     * Create an instance of {@link GetPermissionsResult }
     * 
     */
    public GetPermissionsResult createGetPermissionsResult() {
        return new GetPermissionsResult();
    }

    /**
     * Create an instance of {@link ImpersonateResult }
     * 
     */
    public ImpersonateResult createImpersonateResult() {
        return new ImpersonateResult();
    }

    /**
     * Create an instance of {@link GetPrivilegesStatus }
     * 
     */
    public GetPrivilegesStatus createGetPrivilegesStatus() {
        return new GetPrivilegesStatus();
    }

    /**
     * Create an instance of {@link GetAccounts }
     * 
     */
    public GetAccounts createGetAccounts() {
        return new GetAccounts();
    }

    /**
     * Create an instance of {@link MoveIBotResult }
     * 
     */
    public MoveIBotResult createMoveIBotResult() {
        return new MoveIBotResult();
    }

    /**
     * Create an instance of {@link CancelQueryResult }
     * 
     */
    public CancelQueryResult createCancelQueryResult() {
        return new CancelQueryResult();
    }

    /**
     * Create an instance of {@link PurgeLog }
     * 
     */
    public PurgeLog createPurgeLog() {
        return new PurgeLog();
    }

    /**
     * Create an instance of {@link DescribeTableResult }
     * 
     */
    public DescribeTableResult createDescribeTableResult() {
        return new DescribeTableResult();
    }

    /**
     * Create an instance of {@link SATable }
     * 
     */
    public SATable createSATable() {
        return new SATable();
    }

    /**
     * Create an instance of {@link ExecuteIBotNowResult }
     * 
     */
    public ExecuteIBotNowResult createExecuteIBotNowResult() {
        return new ExecuteIBotNowResult();
    }

    /**
     * Create an instance of {@link CopyItemResult }
     * 
     */
    public CopyItemResult createCopyItemResult() {
        return new CopyItemResult();
    }

    /**
     * Create an instance of {@link GetPromptedColumnsResult }
     * 
     */
    public GetPromptedColumnsResult createGetPromptedColumnsResult() {
        return new GetPromptedColumnsResult();
    }

    /**
     * Create an instance of {@link PromptedColumnInfo }
     * 
     */
    public PromptedColumnInfo createPromptedColumnInfo() {
        return new PromptedColumnInfo();
    }

    /**
     * Create an instance of {@link GetCommonBodyHtml }
     * 
     */
    public GetCommonBodyHtml createGetCommonBodyHtml() {
        return new GetCommonBodyHtml();
    }

    /**
     * Create an instance of {@link SetItemAttributesResult }
     * 
     */
    public SetItemAttributesResult createSetItemAttributesResult() {
        return new SetItemAttributesResult();
    }

    /**
     * Create an instance of {@link GetGlobalPrivilegeACLResult }
     * 
     */
    public GetGlobalPrivilegeACLResult createGetGlobalPrivilegeACLResult() {
        return new GetGlobalPrivilegeACLResult();
    }

    /**
     * Create an instance of {@link UnsubscribeResult }
     * 
     */
    public UnsubscribeResult createUnsubscribeResult() {
        return new UnsubscribeResult();
    }

    /**
     * Create an instance of {@link KeepAlive }
     * 
     */
    public KeepAlive createKeepAlive() {
        return new KeepAlive();
    }

    /**
     * Create an instance of {@link ExecuteIBotNow }
     * 
     */
    public ExecuteIBotNow createExecuteIBotNow() {
        return new ExecuteIBotNow();
    }

    /**
     * Create an instance of {@link GetCurUserResult }
     * 
     */
    public GetCurUserResult createGetCurUserResult() {
        return new GetCurUserResult();
    }

    /**
     * Create an instance of {@link GetConditionCustomizableReportElementsResult }
     * 
     */
    public GetConditionCustomizableReportElementsResult createGetConditionCustomizableReportElementsResult() {
        return new GetConditionCustomizableReportElementsResult();
    }

    /**
     * Create an instance of {@link GetCommonBodyHtmlResult }
     * 
     */
    public GetCommonBodyHtmlResult createGetCommonBodyHtmlResult() {
        return new GetCommonBodyHtmlResult();
    }

    /**
     * Create an instance of {@link UpdateGlobalPrivilegeACL }
     * 
     */
    public UpdateGlobalPrivilegeACL createUpdateGlobalPrivilegeACL() {
        return new UpdateGlobalPrivilegeACL();
    }

    /**
     * Create an instance of {@link UpdateACLParams }
     * 
     */
    public UpdateACLParams createUpdateACLParams() {
        return new UpdateACLParams();
    }

    /**
     * Create an instance of {@link GetGlobalPrivilegesResult }
     * 
     */
    public GetGlobalPrivilegesResult createGetGlobalPrivilegesResult() {
        return new GetGlobalPrivilegesResult();
    }

    /**
     * Create an instance of {@link Privilege }
     * 
     */
    public Privilege createPrivilege() {
        return new Privilege();
    }

    /**
     * Create an instance of {@link SubscribeResult }
     * 
     */
    public SubscribeResult createSubscribeResult() {
        return new SubscribeResult();
    }

    /**
     * Create an instance of {@link SetBridgeResult }
     * 
     */
    public SetBridgeResult createSetBridgeResult() {
        return new SetBridgeResult();
    }

    /**
     * Create an instance of {@link GetSessionEnvironment }
     * 
     */
    public GetSessionEnvironment createGetSessionEnvironment() {
        return new GetSessionEnvironment();
    }

    /**
     * Create an instance of {@link ReadObjectsResult }
     * 
     */
    public ReadObjectsResult createReadObjectsResult() {
        return new ReadObjectsResult();
    }

    /**
     * Create an instance of {@link SaveResultSet }
     * 
     */
    public SaveResultSet createSaveResultSet() {
        return new SaveResultSet();
    }

    /**
     * Create an instance of {@link GetSessionVariablesResult }
     * 
     */
    public GetSessionVariablesResult createGetSessionVariablesResult() {
        return new GetSessionVariablesResult();
    }

    /**
     * Create an instance of {@link GetHtmlForPageWithOneReportResult }
     * 
     */
    public GetHtmlForPageWithOneReportResult createGetHtmlForPageWithOneReportResult() {
        return new GetHtmlForPageWithOneReportResult();
    }

    /**
     * Create an instance of {@link RemoveFolder }
     * 
     */
    public RemoveFolder createRemoveFolder() {
        return new RemoveFolder();
    }

    /**
     * Create an instance of {@link SetItemProperty }
     * 
     */
    public SetItemProperty createSetItemProperty() {
        return new SetItemProperty();
    }

    /**
     * Create an instance of {@link EvaluateConditionResult }
     * 
     */
    public EvaluateConditionResult createEvaluateConditionResult() {
        return new EvaluateConditionResult();
    }

    /**
     * Create an instance of {@link EndPage }
     * 
     */
    public EndPage createEndPage() {
        return new EndPage();
    }

    /**
     * Create an instance of {@link UpdateCatalogItemACLResult }
     * 
     */
    public UpdateCatalogItemACLResult createUpdateCatalogItemACLResult() {
        return new UpdateCatalogItemACLResult();
    }

    /**
     * Create an instance of {@link RemoveFolderResult }
     * 
     */
    public RemoveFolderResult createRemoveFolderResult() {
        return new RemoveFolderResult();
    }

    /**
     * Create an instance of {@link CreateLink }
     * 
     */
    public CreateLink createCreateLink() {
        return new CreateLink();
    }

    /**
     * Create an instance of {@link GetSubjectAreas }
     * 
     */
    public GetSubjectAreas createGetSubjectAreas() {
        return new GetSubjectAreas();
    }

    /**
     * Create an instance of {@link GetPromptedFilters }
     * 
     */
    public GetPromptedFilters createGetPromptedFilters() {
        return new GetPromptedFilters();
    }

    /**
     * Create an instance of {@link VoidType }
     * 
     */
    public VoidType createVoidType() {
        return new VoidType();
    }

    /**
     * Create an instance of {@link GetMembersResult }
     * 
     */
    public GetMembersResult createGetMembersResult() {
        return new GetMembersResult();
    }

    /**
     * Create an instance of {@link LogonexResult }
     * 
     */
    public LogonexResult createLogonexResult() {
        return new LogonexResult();
    }

    /**
     * Create an instance of {@link Impersonateex }
     * 
     */
    public Impersonateex createImpersonateex() {
        return new Impersonateex();
    }

    /**
     * Create an instance of {@link UpgradeXML }
     * 
     */
    public UpgradeXML createUpgradeXML() {
        return new UpgradeXML();
    }

    /**
     * Create an instance of {@link ApplyReportParamsResult }
     * 
     */
    public ApplyReportParamsResult createApplyReportParamsResult() {
        return new ApplyReportParamsResult();
    }

    /**
     * Create an instance of {@link MoveIBot }
     * 
     */
    public MoveIBot createMoveIBot() {
        return new MoveIBot();
    }

    /**
     * Create an instance of {@link Export }
     * 
     */
    public Export createExport() {
        return new Export();
    }

    /**
     * Create an instance of {@link ApplyReportDefaults }
     * 
     */
    public ApplyReportDefaults createApplyReportDefaults() {
        return new ApplyReportDefaults();
    }

    /**
     * Create an instance of {@link WriteIBotResult }
     * 
     */
    public WriteIBotResult createWriteIBotResult() {
        return new WriteIBotResult();
    }

    /**
     * Create an instance of {@link WriteIBot }
     * 
     */
    public WriteIBot createWriteIBot() {
        return new WriteIBot();
    }

    /**
     * Create an instance of {@link ClearQueryCache }
     * 
     */
    public ClearQueryCache createClearQueryCache() {
        return new ClearQueryCache();
    }

    /**
     * Create an instance of {@link CopyItem2Result }
     * 
     */
    public CopyItem2Result createCopyItem2Result() {
        return new CopyItem2Result();
    }

    /**
     * Create an instance of {@link ExecuteSQLQuery }
     * 
     */
    public ExecuteSQLQuery createExecuteSQLQuery() {
        return new ExecuteSQLQuery();
    }

    /**
     * Create an instance of {@link XMLQueryExecutionOptions }
     * 
     */
    public XMLQueryExecutionOptions createXMLQueryExecutionOptions() {
        return new XMLQueryExecutionOptions();
    }

    /**
     * Create an instance of {@link ApplyReportParams }
     * 
     */
    public ApplyReportParams createApplyReportParams() {
        return new ApplyReportParams();
    }

    /**
     * Create an instance of {@link GetSessionEnvironmentResult }
     * 
     */
    public GetSessionEnvironmentResult createGetSessionEnvironmentResult() {
        return new GetSessionEnvironmentResult();
    }

    /**
     * Create an instance of {@link SessionEnvironment }
     * 
     */
    public SessionEnvironment createSessionEnvironment() {
        return new SessionEnvironment();
    }

    /**
     * Create an instance of {@link UpgradeXMLResult }
     * 
     */
    public UpgradeXMLResult createUpgradeXMLResult() {
        return new UpgradeXMLResult();
    }

    /**
     * Create an instance of {@link GetMembers }
     * 
     */
    public GetMembers createGetMembers() {
        return new GetMembers();
    }

    /**
     * Create an instance of {@link GetSubItems }
     * 
     */
    public GetSubItems createGetSubItems() {
        return new GetSubItems();
    }

    /**
     * Create an instance of {@link GetSubItemsParams }
     * 
     */
    public GetSubItemsParams createGetSubItemsParams() {
        return new GetSubItemsParams();
    }

    /**
     * Create an instance of {@link DescribeTable }
     * 
     */
    public DescribeTable createDescribeTable() {
        return new DescribeTable();
    }

    /**
     * Create an instance of {@link CreateLinkResult }
     * 
     */
    public CreateLinkResult createCreateLinkResult() {
        return new CreateLinkResult();
    }

    /**
     * Create an instance of {@link GetCountsResult }
     * 
     */
    public GetCountsResult createGetCountsResult() {
        return new GetCountsResult();
    }

    /**
     * Create an instance of {@link ExportResult }
     * 
     */
    public ExportResult createExportResult() {
        return new ExportResult();
    }

    /**
     * Create an instance of {@link PurgeCacheResult }
     * 
     */
    public PurgeCacheResult createPurgeCacheResult() {
        return new PurgeCacheResult();
    }

    /**
     * Create an instance of {@link JoinGroups }
     * 
     */
    public JoinGroups createJoinGroups() {
        return new JoinGroups();
    }

    /**
     * Create an instance of {@link ClearQueryCacheResult }
     * 
     */
    public ClearQueryCacheResult createClearQueryCacheResult() {
        return new ClearQueryCacheResult();
    }

    /**
     * Create an instance of {@link ExecuteXMLQuery }
     * 
     */
    public ExecuteXMLQuery createExecuteXMLQuery() {
        return new ExecuteXMLQuery();
    }

    /**
     * Create an instance of {@link DescribeSubjectArea }
     * 
     */
    public DescribeSubjectArea createDescribeSubjectArea() {
        return new DescribeSubjectArea();
    }

    /**
     * Create an instance of {@link ExecuteXMLQueryResult }
     * 
     */
    public ExecuteXMLQueryResult createExecuteXMLQueryResult() {
        return new ExecuteXMLQueryResult();
    }

    /**
     * Create an instance of {@link GetHtmlForPageWithOneReport }
     * 
     */
    public GetHtmlForPageWithOneReport createGetHtmlForPageWithOneReport() {
        return new GetHtmlForPageWithOneReport();
    }

    /**
     * Create an instance of {@link Unsubscribe }
     * 
     */
    public Unsubscribe createUnsubscribe() {
        return new Unsubscribe();
    }

    /**
     * Create an instance of {@link GenerateReportSQLResult }
     * 
     */
    public GenerateReportSQLResult createGenerateReportSQLResult() {
        return new GenerateReportSQLResult();
    }

    /**
     * Create an instance of {@link DescribeColumn }
     * 
     */
    public DescribeColumn createDescribeColumn() {
        return new DescribeColumn();
    }

    /**
     * Create an instance of {@link SAWException }
     * 
     */
    public SAWException createSAWException() {
        return new SAWException();
    }

    /**
     * Create an instance of {@link TemplateInfoInstance }
     * 
     */
    public TemplateInfoInstance createTemplateInfoInstance() {
        return new TemplateInfoInstance();
    }

    /**
     * Create an instance of {@link TemplateInfo }
     * 
     */
    public TemplateInfo createTemplateInfo() {
        return new TemplateInfo();
    }

    /**
     * Create an instance of {@link JobStats }
     * 
     */
    public JobStats createJobStats() {
        return new JobStats();
    }

    /**
     * Create an instance of {@link Variable }
     * 
     */
    public Variable createVariable() {
        return new Variable();
    }

    /**
     * Create an instance of {@link AccessControlToken }
     * 
     */
    public AccessControlToken createAccessControlToken() {
        return new AccessControlToken();
    }

    /**
     * Create an instance of {@link NameValueArrayPair }
     * 
     */
    public NameValueArrayPair createNameValueArrayPair() {
        return new NameValueArrayPair();
    }

    /**
     * Create an instance of {@link GetSubItemsFilter }
     * 
     */
    public GetSubItemsFilter createGetSubItemsFilter() {
        return new GetSubItemsFilter();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link PathMapEntry }
     * 
     */
    public PathMapEntry createPathMapEntry() {
        return new PathMapEntry();
    }

    /**
     * Create an instance of {@link LogonParameter }
     * 
     */
    public LogonParameter createLogonParameter() {
        return new LogonParameter();
    }

    /**
     * Create an instance of {@link NameValuePair }
     * 
     */
    public NameValuePair createNameValuePair() {
        return new NameValuePair();
    }

    /**
     * Create an instance of {@link SAWLocale }
     * 
     */
    public SAWLocale createSAWLocale() {
        return new SAWLocale();
    }

    /**
     * Create an instance of {@link JobInfo.DetailedInfo }
     * 
     */
    public JobInfo.DetailedInfo createJobInfoDetailedInfo() {
        return new JobInfo.DetailedInfo();
    }

}
