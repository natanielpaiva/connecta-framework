package br.com.cds.connecta.framework.core.business.aplicationService.common;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;

@Service
public abstract class AbstractBaseAS<E extends AbstractBaseEntity> {

    public abstract AbstractBaseEntity get(Long id) throws Exception;

    public abstract List<E> list() throws Exception;

    public abstract E saveOrUpdate(E entity) throws Exception;

    public abstract void delete(Long id) throws Exception;

    public abstract void delete(E entity) throws Exception;

}
