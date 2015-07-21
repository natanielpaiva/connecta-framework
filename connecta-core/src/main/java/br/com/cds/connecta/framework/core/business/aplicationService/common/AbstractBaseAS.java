package br.com.cds.connecta.framework.core.business.aplicationService.common;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.filter.PaginationFilter;
import org.springframework.data.domain.Page;

@Service
public abstract class AbstractBaseAS<E extends AbstractBaseEntity> {

    public E save(E entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public E saveOrUpdate(E entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    };

    public E update(E entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public E get(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<E> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Page<E> find(PaginationFilter filter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(E entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
