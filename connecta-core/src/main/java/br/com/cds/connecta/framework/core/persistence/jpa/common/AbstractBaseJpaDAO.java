package br.com.cds.connecta.framework.core.persistence.jpa.common;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.util.Util;

/**
 * Classe base para os serviços de persistência 
 * 
 * @author Ryan A. Thuin
 * @version 0.1
 * 
 */

@Repository
@Configuration
public abstract class AbstractBaseJpaDAO<E extends AbstractBaseEntity> {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;

	/**
	 * Retorna o EntityManager
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Define o EntityManager
	 * 
	 * @param entityManager
	 */
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected Class<E> entityClass = null;

	@SuppressWarnings("unchecked")
	public E get(Long id) {
		return (E) entityManager.find(getEntityClass(), id);
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
			attach = entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
			attach = entity;
		}

		if (flush) {
			flush();
		}

		return attach;
	}

	protected void flush() {
		entityManager.flush();
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

		entityManager.remove(entity);
		if (flush) {
			flush();
		}
	}

	protected boolean contains(E entity) {
		return entityManager.contains(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		entityManager.refresh(entity);
	}

	protected void clearEntities() {
		entityManager.clear();
	}

	protected void clearCache() {
		entityManager.getEntityManagerFactory().getCache()
				.evict(getEntityClass());
	}

	protected Query createNamedQuery(String namedQuery) {
		return entityManager.createNamedQuery(namedQuery);
	}

	protected Query createNamedQuery(String namedQuery, Class<E> resultClass) {
		return entityManager.createNamedQuery(namedQuery, resultClass);
	}

	protected Query createNativeQuery(String namedQuery) {
		return entityManager.createNativeQuery(namedQuery);
	}

	protected Query createNativeQuery(String namedQuery, Class<?> resultClass) {
		return entityManager.createNativeQuery(namedQuery, resultClass);
	}

}
