package br.com.cds.connecta.framework.core.persistence.jpa.common;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Configuration;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.search.filter.PaginationFilter;
import br.com.cds.connecta.framework.core.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

/**
 * Classe base para os serviços de persistência
 *
 * @author Ryan A. Thuin
 * @version 0.1
 * @param <E> Tipo da Entidade
 *
 */
@Repository
@Configuration
public abstract class AbstractBaseJpaDAO<E extends AbstractBaseEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    protected Class<E> entityClass = null;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public E get(Long id) {
        return (E) getEntityManager().find(getEntityClass(), id);
    }

    public E saveOrUpdate(E entity) {
        return saveOrUpdate(entity, true);
    }

    protected E saveOrUpdate(E entity, boolean flush) {

        E attach = null;

        if (Util.isNull(entity)) {
            throw new IllegalArgumentException("A entidade não pode ser nula.");
        }

        if (!Util.isNull(entity.getId())) {
            attach = getEntityManager().merge(entity);
        } else {
            getEntityManager().persist(entity);
            attach = entity;
        }

        if (flush) {
            flush();
        }

        return attach;
    }

    protected void flush() {
        getEntityManager().flush();
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("A entidade não pode ser nula.");
        }
        E obj = get(id);
        delete(obj);
    }

    public void delete(E entity) {
        delete(entity, true);
    }

    protected void delete(E entity, boolean flush) {
        if (Util.isNull(entity)) {
            throw new IllegalArgumentException("A entidade não pode ser nula.");
        }

        getEntityManager().remove(entity);
        if (flush) {
            flush();
        }
    }

    protected boolean contains(E entity) {
        return getEntityManager().contains(entity);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected Class getEntityClass() {
        if (entityClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            entityClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    protected void refresh(E entity) {
        getEntityManager().refresh(entity);
    }

    protected void clearEntities() {
        getEntityManager().clear();
    }

    protected void clearCache() {
        getEntityManager().getEntityManagerFactory().getCache()
                .evict(getEntityClass());
    }

    protected Query createNamedQuery(String namedQuery) {
        return getEntityManager().createNamedQuery(namedQuery);
    }

    protected TypedQuery<E> createNamedQuery(String namedQuery, Class<E> resultClass) {
        return getEntityManager().createNamedQuery(namedQuery, resultClass);
    }

    protected Query createNativeQuery(String namedQuery) {
        return getEntityManager().createNativeQuery(namedQuery);
    }

    protected Query createNativeQuery(String namedQuery, Class<?> resultClass) {
        return getEntityManager().createNativeQuery(namedQuery, resultClass);
    }

    protected PageImpl<E> search(PaginationFilter filter, String searchNQ, String countNQ) {
        //Retorna o total de resultados
        Query count = createNamedQuery(countNQ);
        for (String key : filter.getFilter().keySet()) {
            if (isParameterDefault(key)) {
                count.setParameter(key, filter.getFilter().get(key));
            } else {
                count.setParameter(key, "%" + filter.getFilter().get(key) + "%");
            }
        }
        setParametersWithoutValues(count, filter.getFilter());
        Long total = (Long) count.getSingleResult();
        //Retorna a lista de resultados
        Query query = createNamedQuery(searchNQ);
        for (String key : filter.getFilter().keySet()) {
            if (isParameterDefault(key)) {
                query.setParameter(key, filter.getFilter().get(key));
            } else {
                query.setParameter(key, "%" + filter.getFilter().get(key) + "%");
            }
        }
        setParametersWithoutValues(query, filter.getFilter());
        query.setFirstResult((filter.getPage() - 1) * 10);
        query.setMaxResults(filter.getCount());
        List resultList = query.getResultList();
        //Cria o Page
        return new PageImpl<>(resultList, filter.makePageable(), total);
    }

    /**
     * Método que seta as variáveis não setadas pelo filter como nulas
     *
     * @param query
     * @param filter
     */
    private void setParametersWithoutValues(Query query, HashMap<String, Object> filter) {
        Set<String> withValues = filter.keySet();
        Set<Parameter<?>> parameters = query.getParameters();
        Iterator<Parameter<?>> iterator = parameters.iterator();
        while (iterator.hasNext()) {
            Parameter<?> next = iterator.next();
            if (!withValues.contains(next.getName())) {
                query.setParameter(next.getName(), null);
            }
        }
    }
    
    public boolean isParameterDefault(String parameter){
        String[] parameters = {"userId", "companies", "companyId"};
        return Arrays.asList(parameters).contains(parameter);
    }
}
