package br.com.cds.connecta.framework.core.business.aplicationService.impl;

import br.com.cds.connecta.framework.core.business.aplicationService.IConnectaSharedIndexerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@Service
public class ConnectaSharedIndexerServiceImpl implements IConnectaSharedIndexerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveIndex() {
        FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
        try {
            ftem.createIndexer().startAndWait();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
