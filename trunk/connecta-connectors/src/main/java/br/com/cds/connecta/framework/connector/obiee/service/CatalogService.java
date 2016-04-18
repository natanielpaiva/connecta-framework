package br.com.cds.connecta.framework.connector.obiee.service;

import br.com.cds.connecta.framework.connector.obiee.ItemInfo;
import br.com.cds.connecta.framework.connector.obiee.ItemInfoType;
import br.com.cds.connecta.framework.connector.obiee.WebCatalogService;
import br.com.cds.connecta.framework.connector.obiee.bean.FileBIBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

//import net.sf.json.JSONObject;
//import br.com.cds.presenter.businnes.bean.obiee.FileBIBean;
//import br.com.cds.presenter.businnes.wsdl.oracle.bi.web.soap.ItemInfo;
//import br.com.cds.presenter.businnes.wsdl.oracle.bi.web.soap.ItemInfoType;
//import br.com.cds.presenter.businnes.wsdl.oracle.bi.web.soap.WebCatalogService;
/**
 *
 * @author jhonatas
 *
 * Serviço que provê acesso aos serviços de Catálogo do OBIEE.
 *
 */
public class CatalogService {

    private static final String PATH = "/shared/";
    private String pathTemp = PATH;
    private WebCatalogService service;

    public CatalogService() {
        service = new WebCatalogService();
    }

    public CatalogService(String wsdlLocation) {
        try {
            service = new WebCatalogService(new URL(wsdlLocation));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public List listFileBI(String session, String path) {

        if (path != null && !path.isEmpty()) {
            pathTemp = path;
        }

        return this.listFileBI(session);
    }

    public List listFileBI(String session) {
        List<FileBIBean> arquivos = new ArrayList<FileBIBean>();
        List<ItemInfo> lista;

        try {
            lista = service.getWebCatalogServiceSoap().getSubItems(pathTemp, "", true, null, session);

            if (!lista.isEmpty()) {
                for (ItemInfo item : lista) {
                    FileBIBean.Type tipo = getTypeOfItemInfo(item.getType());
                    arquivos.add(new FileBIBean(item.getCaption(), item.getPath(), tipo));
                }
            }
        } catch (SOAPFaultException e) {
            e.printStackTrace();
//                json.put("_message", "Diretório ou arquivo não encontrado !");
        }

        return arquivos;
    }

    private FileBIBean.Type getTypeOfItemInfo(ItemInfoType infTipo) {
        FileBIBean.Type tipo;

        if (infTipo == ItemInfoType.FOLDER) {
            tipo = FileBIBean.Type.folder;
        } else if (infTipo == ItemInfoType.LINK) {
            tipo = FileBIBean.Type.link;
        } else if (infTipo == ItemInfoType.OBJECT) {
            tipo = FileBIBean.Type.object;
        } else if (infTipo == ItemInfoType.NO_ACCESS) {
            tipo = FileBIBean.Type.noaccess;
        } else {
            tipo = FileBIBean.Type.unknow;
        }

        return tipo;
    }

}
