package br.com.cds.connecta.framework.core.business.aplicationService.common;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;



@Service
public abstract class AbstractBaseAS<E extends AbstractBaseEntity> {
	
	
	protected abstract AbstractBaseEntity get(Long id) throws Exception;		

	
	protected abstract List<AbstractBaseEntity> list() throws Exception;

	
	protected abstract AbstractBaseEntity saveOrUpdate(AbstractBaseEntity entity) throws Exception; 
	
	
	protected abstract void delete(Long id) throws Exception;
		

	protected abstract void deleteAll(List<Long> listIds) throws Exception;
	
	

}
