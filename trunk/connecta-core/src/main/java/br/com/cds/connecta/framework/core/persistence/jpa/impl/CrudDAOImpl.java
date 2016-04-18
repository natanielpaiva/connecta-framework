package br.com.cds.connecta.framework.core.persistence.jpa.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.persistence.jpa.ICrudDAO;
import br.com.cds.connecta.framework.core.persistence.jpa.common.AbstractBaseJpaDAO;

@Service
public final class CrudDAOImpl extends AbstractBaseJpaDAO<AbstractBaseEntity> implements ICrudDAO {
            
    @Override
    public AbstractBaseEntity saveOrUpdate(AbstractBaseEntity entity) {
        return super.saveOrUpdate(entity);
    }

    @Override
    public AbstractBaseEntity get(Long id) {
        return super.get(id);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void delete(AbstractBaseEntity entity) {
        if (entity != null) {
            getEntityManager().remove(entity);
            getEntityManager().flush();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AbstractBaseEntity> list() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        @SuppressWarnings("rawtypes")
        CriteriaQuery cq = cb.createQuery();
        Root<AbstractBaseEntity> root = cq.from(getEntityClass());
        cq.select(root);
        cq.orderBy(cb.desc(root.get("id")));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
