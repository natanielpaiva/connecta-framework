package br.com.cds.connecta.framework.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cds.connecta.framework.core.business.aplicationService.ICrudAS;
import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    protected ResponseEntity<AbstractBaseEntity> get(Long id, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AbstractBaseEntity entity = getCrudAS().get(id);
        return new ResponseEntity<AbstractBaseEntity>(entity, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<List<AbstractBaseEntity>> list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<AbstractBaseEntity> list = getCrudAS().list();
        return new ResponseEntity<List<AbstractBaseEntity>>(list, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<AbstractBaseEntity> save(AbstractBaseEntity entity,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AbstractBaseEntity newEntity = getCrudAS().saveOrUpdate(entity);
        return new ResponseEntity<AbstractBaseEntity>(newEntity, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<AbstractBaseEntity> update(Long id, AbstractBaseEntity entity,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AbstractBaseEntity newEntity = getCrudAS().saveOrUpdate(entity);
        return new ResponseEntity<AbstractBaseEntity>(newEntity, HttpStatus.OK);
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
