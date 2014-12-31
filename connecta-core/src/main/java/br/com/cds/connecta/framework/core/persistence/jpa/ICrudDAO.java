package br.com.cds.connecta.framework.core.persistence.jpa;

import java.util.List;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;

public interface ICrudDAO {

	public abstract AbstractBaseEntity saveOrUpdate(AbstractBaseEntity entity);

	public abstract AbstractBaseEntity get(Long id);

	public abstract void delete(Long id);

	public abstract void delete(AbstractBaseEntity entity);

	public abstract List<AbstractBaseEntity> list();
	
	 public void setEntityClass(Class<AbstractBaseEntity> entityClass); 

}