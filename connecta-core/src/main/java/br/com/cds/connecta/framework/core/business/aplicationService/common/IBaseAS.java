package br.com.cds.connecta.framework.core.business.aplicationService.common;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.filter.PaginationFilter;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Julio Lemes
 * @param <E>
 * @date May 29, 2015
 */
public interface IBaseAS <E extends AbstractBaseEntity> {
    
    E save(E entity);
    E update(E entity);
    E get(Long id);
    List<E> list();
    Page<E> find(PaginationFilter filter);
    void delete (Long id);
    void delete (E entity);

}
