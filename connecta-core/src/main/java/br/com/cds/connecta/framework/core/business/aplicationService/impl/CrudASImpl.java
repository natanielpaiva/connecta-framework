package br.com.cds.connecta.framework.core.business.aplicationService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cds.connecta.framework.core.business.aplicationService.ICrudAS;
import br.com.cds.connecta.framework.core.business.aplicationService.common.AbstractBaseAS;
import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.persistence.jpa.ICrudDAO;

public final class CrudASImpl extends AbstractBaseAS<AbstractBaseEntity> implements ICrudAS {

	@Autowired
	protected ICrudDAO crudDao;
		
	protected Class<AbstractBaseEntity> entityClass;

	

	@Override
	public AbstractBaseEntity get(Long id) throws Exception {
		crudDao.setEntityClass(getEntityClass());
		return crudDao.get(id);
	}

	@Override
	public List<AbstractBaseEntity> list() throws Exception {
		crudDao.setEntityClass(getEntityClass());
		return crudDao.list();
	}

	@Override
	public AbstractBaseEntity saveOrUpdate(AbstractBaseEntity entity)
			throws Exception {
		crudDao.setEntityClass(getEntityClass());
		return crudDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Long id) throws Exception {
		crudDao.setEntityClass(getEntityClass());
		crudDao.delete(id);
	}
	
	@Override
	public Class<AbstractBaseEntity> getEntityClass() {
		return entityClass;
	}

	@Override
	public void setEntityClass(Class<AbstractBaseEntity> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public ICrudDAO getCrudDao() {
		return crudDao;
	}

	@Override
	public void setCrudDao(ICrudDAO crudDao) {
		this.crudDao = crudDao;
	}

	@Override
	public void delete(AbstractBaseEntity entity) throws Exception {
		crudDao.setEntityClass(getEntityClass());
		crudDao.delete(entity);
	}

	
}
