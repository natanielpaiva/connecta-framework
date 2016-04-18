package br.com.cds.connecta.framework.core.business.aplicationService;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public interface IConnectaSharedIndexerService {

    /**
     * Reindexa todo o conteúdo de uma entidade no Solr,
     * esse método é super pesado, esteja avisado.
     * PS.: O nome do método era pra ser só index, mas teve que pegar transaction ¬¬
     */
    void saveIndex();

}
