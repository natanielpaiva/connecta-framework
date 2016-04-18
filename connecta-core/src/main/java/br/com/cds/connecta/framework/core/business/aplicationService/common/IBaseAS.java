package br.com.cds.connecta.framework.core.business.aplicationService.common;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.search.filter.PaginationFilter;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Julio Lemes
 * @param <E>
 * @date May 29, 2015
 */
public interface IBaseAS <E extends AbstractBaseEntity> {
    
    E save(E entity) throws Exception;
    public E saveOrUpdate(E entity) throws Exception;
    E update(E entity) throws Exception;
    E get(Long id) throws Exception;
    List<E> list() throws Exception;
    Page<E> find(PaginationFilter filter) throws Exception;
    void delete (Long id) throws Exception;
    void delete (E entity) throws Exception;

}
