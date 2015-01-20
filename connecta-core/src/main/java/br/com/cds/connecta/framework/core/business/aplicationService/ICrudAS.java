package br.com.cds.connecta.framework.core.business.aplicationService;

import java.util.List;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.persistence.jpa.ICrudDAO;

public interface ICrudAS {

    public abstract Class<AbstractBaseEntity> getEntityClass();

    public abstract void setEntityClass(Class<AbstractBaseEntity> entityClass);

    public abstract AbstractBaseEntity get(Long id) throws Exception;

    public abstract List<AbstractBaseEntity> list() throws Exception;

    public abstract AbstractBaseEntity saveOrUpdate(AbstractBaseEntity entity)
            throws Exception;

    public abstract void delete(Long id) throws Exception;

    public abstract ICrudDAO getCrudDao();

    public abstract void setCrudDao(ICrudDAO crudDao);

}
