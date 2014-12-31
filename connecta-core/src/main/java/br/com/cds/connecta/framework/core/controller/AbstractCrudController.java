package br.com.cds.connecta.framework.core.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cds.connecta.framework.core.business.aplicationService.ICrudAS;
import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;

/**
 * Classe base com CRUD para Controladoras 
 * 
 */
public abstract class AbstractCrudController extends AbstractBaseController<AbstractBaseEntity> {
	
	@Autowired
	protected ICrudAS crudAS;
	
	public AbstractCrudController(Class<AbstractBaseEntity> entityClass) {
		this.getCrudAS().setEntityClass(entityClass);
	}

	@Override
	protected AbstractBaseEntity get(Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getCrudAS().get(id);
	}

	@Override
	protected List<AbstractBaseEntity> list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getCrudAS().list();
	}

	@Override
	protected AbstractBaseEntity save(AbstractBaseEntity entity,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getCrudAS().saveOrUpdate(entity);
	}

	@Override
	protected AbstractBaseEntity update(Long id, AbstractBaseEntity entity,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getCrudAS().saveOrUpdate(entity);
	}

	@Override
	protected void delete(Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    getCrudAS().delete(id);
	}

	public ICrudAS getCrudAS() {
		return crudAS;
	}

	public void setCrudAS(ICrudAS crudAS) {
		this.crudAS = crudAS;
	}
	
   
}
