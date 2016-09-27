/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.obiee.service;

import br.com.cds.connecta.framework.connector.obiee.CatalogObject;
import br.com.cds.connecta.framework.connector.obiee.ErrorDetailsLevel;
import br.com.cds.connecta.framework.connector.obiee.ReadObjectsReturnOptions;
import br.com.cds.connecta.framework.connector.obiee.ReportEditingService;
import br.com.cds.connecta.framework.connector.obiee.ReportRef;
import br.com.cds.connecta.framework.connector.obiee.WebCatalogService;
import br.com.cds.connecta.framework.connector.obiee.WebCatalogServiceSoap;
import br.com.cds.connecta.framework.connector.obiee.XmlViewService;
import br.com.cds.connecta.framework.connector.obiee.XmlViewServiceSoap;
import br.com.cds.connecta.framework.connector.obiee.bean.FilterBean;
import br.com.cds.connecta.framework.connector.obiee.bean.ReportAttr;
import br.com.cds.connecta.framework.connector.obiee.util.DomUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.soap.SOAPFaultException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author diego
 */
public class ReportService {

    private XmlViewService xmlService;
    private ReportEditingService reportEditingService;
    private WebCatalogService webCatalogService;

    public ReportService(String wsdlLocation) {
        URL url = null;
        try {
            url = new URL(wsdlLocation);

            xmlService = new XmlViewService(url);
            reportEditingService = new ReportEditingService(url);
            webCatalogService = new WebCatalogService(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, List<String>> getMetadata(String path, String session) {
        HashMap<String, List<String>> metadata = new HashMap<>();

        ReportRef rep = new ReportRef();
        rep.setReportPath(path);

        // adicionando o path da análise
        List<String> paths = new ArrayList<>();
        paths.add(path);

        List<String> columns = new ArrayList<>();
        List<String> columnsFormula = new ArrayList<>();
        List<String> filters = new ArrayList<>();

        try {
            // Object elementoColumnCache = getCacheAnalysisColumns().get(path);
            // TODO retidada temporária do cache de consulta aos metadados do
            // OBIEE;
            Object elementoColumnCache = null;
            if (elementoColumnCache == null) {
                CatalogObject objeto = null;
                // recuperando os metadados da análise
                WebCatalogServiceSoap webCatalogServiceSoap = webCatalogService
                        .getWebCatalogServiceSoap();
                List<CatalogObject> objects = webCatalogServiceSoap
                        .readObjects(paths, true,
                                ErrorDetailsLevel.ERROR_CODE_AND_TEXT,
                                ReadObjectsReturnOptions.OBJECT_AS_STRING,
                                session);
                if (objects != null && objects.size() > 0) {
                    objeto = objects.get(0);
                }

                if (objeto != null) {
                    Document xml = DomUtils.converterStringToDocumentXML(objeto
                            .getCatalogObject());

                    if(xml == null){
                        return null;
                    }

                    Element root = xml.getDocumentElement();

                    NodeList rootChilds = root.getChildNodes();

                    // recuperando as colunas da análise
                    List<ReportAttr> header = nodeListCabecalhoMetadata(
                            rootChilds, null);

                    int i = 1;

                    for (ReportAttr attr : header) {
                        String formula =  attr.getFormula();
                        String columnName;

                        // quando não há título personalizado para a coluna
                        if (attr.getValue().trim().equals("")) {

                            boolean flag = formula.indexOf("CASE") > -1
                                    || formula.indexOf("WHEN") > -1
                                    || formula.indexOf("AGGREGATE") > -1
                                    || formula.indexOf("SUM") > -1
                                    || formula.indexOf("AVERAGE") > -1;

                            if (!flag && !formula.isEmpty() && formula.contains(".")) {
                                columnName = formula.split("\\.")[1];
                            } else {
                                columnName = "column" + i;
                            }

                        } else {
                            columnName = attr.getValue();
                        }

                        columns.add(columnName);
                        columnsFormula.add(("(" + attr.getFormula() + ")"));
                        i++;
                    }
                }
                List<List<String>> colunasCache = new ArrayList<List<String>>();
                colunasCache.add(columns);
                colunasCache.add(columnsFormula);
		//getCacheAnalysisColumns().put(path, colunasCache);
            } else {
                List<List<String>> colunasCache = (List<List<String>>) elementoColumnCache;
                columns = colunasCache.get(0);
                columnsFormula = colunasCache.get(1);
            }

		//Object elementoFilterCache = getCacheAnalysisFilter().get(path);
            List<FilterBean> filtros;
            XmlViewServiceSoap serviceSoap = xmlService
                    .getXmlViewServiceSoap();
            List<String> rfiltro = serviceSoap.getPromptedFilters(rep,
                    session);
            // recuperando os filtros da analise
            filtros = this.getColumnsFilter(rfiltro);

            for (FilterBean filter : filtros) {
                filters.add(filter.getName());
            }

            //result.put("_success", true);
            //metadata.put("path", path);
            //metadata.put("filters", filters);
            metadata.put("columns", columns);
            metadata.put("formula", columnsFormula);
            
            //result.put("metadata", metadata);

        } catch (SOAPFaultException ex) {
            //result.put("_message", "Erro ao buscar metadados");
            ex.printStackTrace();
        }
        
        return metadata;
    }

    private List<ReportAttr> nodeListCabecalhoMetadata(NodeList nodelist,
            List<FilterBean> filtros) {
        List<ReportAttr> listaHead = new ArrayList<ReportAttr>();

        Node nodeColunas = findNode(nodelist, "saw:columns");
        NodeList nodeListColunas = (nodeColunas != null ? nodeColunas
                .getChildNodes() : null);
        if (nodeListColunas != null) {
            for (int i = 0; i < nodeListColunas.getLength(); i++) {
                Node node = nodeListColunas.item(i);
                if (!node.getNodeName().equals("saw:column")) {
                    node = findNode(nodelist, "saw:column");
                }
                if (node != null) {
                    ReportAttr rep = new ReportAttr();
                    Node nodeFormula = findNode(node.getChildNodes(),
                            "saw:columnFormula");
                    if (nodeFormula != null && nodeFormula.hasChildNodes()) {
                        Node nodeFormulaExpr = findNode(
                                nodeFormula.getChildNodes(), "sawx:expr");
                        if (nodeFormulaExpr != null) {
                            rep.setFormula(nodeFormulaExpr.getTextContent());
                        }
                    }

                    Node nodeName = findNode(node.getChildNodes(),
                            "saw:columnHeading");
                    if (nodeName != null && nodeName.hasChildNodes()) {
                        Node nodeNameExpr = findNode(nodeName.getChildNodes(),
                                "saw:text");
                        if (nodeNameExpr != null) {
                            rep.setValue(nodeNameExpr.getTextContent());
                        } else {
                            String[] formula = rep.getFormula().split("\\.");
                            if (formula.length > 0) {
                                rep.setValue(formula[formula.length - 1]);
                            }
                        }
                    }
                    listaHead.add(rep);
                }
            }
        }
        return listaHead;
    }

    private Node findNode(NodeList nodeList, String textoFind) {
        NodeList nodes = nodeList;
        Node node = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            node = nodes.item(i);
            if (node.getNodeName().equals(textoFind)) {
                return node;
            } else {
                if (node.hasChildNodes()) {
                    Node nodeRet = findNode(node.getChildNodes(), textoFind);
                    if (nodeRet != null) {
                        return nodeRet;
                    }
                }
            }
        }
        return null;
    }
    
    
    private List<FilterBean> getColumnsFilter(List<String> filtros) {
        List<FilterBean> resultado = new ArrayList<FilterBean>();

        if (filtros != null && !filtros.isEmpty()) {
            for (String xml : filtros) {
                FilterBean filtro = this.getFilterObject(xml);
                resultado.add(filtro);
            }
        }

        return resultado;
    }
    
    private FilterBean getFilterObject(String xml) {
        FilterBean filtro = null;

        Document doc = DomUtils.converterStringToDocumentXML(xml);
        filtro = this.readFilterXML(doc.getDocumentElement().getChildNodes());

        return filtro;
    }
    
    private FilterBean readFilterXML(NodeList nodelist) {
        FilterBean filtro = new FilterBean();

        for (int i = 0; i < nodelist.getLength(); i++) {
            Node node = nodelist.item(i);
            String valor = this.readNodeAttrFilter(node);

            if (valor == null && node.hasChildNodes()) {
                filtro = this.readFilterXML(node.getChildNodes());
            } else if (valor != null) {
                filtro.setName(valor);
            }
        }

        return filtro;
    }
    
    private String readNodeAttrFilter(Node node) {
        String resultado = null;

        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            for (int j = 0; j < attrs.getLength(); j++) {
                Node nd = attrs.item(j);
                if (nd.getNodeName().equals("xsi:type")) {
                    if (nd.getNodeValue().equals("sawx:sqlExpression")) {
                        resultado = node.getTextContent();
                    }
                }
            }
        }
        return resultado;
    }
}
