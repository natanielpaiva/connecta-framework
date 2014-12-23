package br.com.cds.connecta.framework.core.entity;

import br.com.cds.connecta.framework.core.bean.common.AbstractBaseBean;

/**
 * 
 * @author Ryan A. Thuin
 * @version 1.0.0
 *
 */
public abstract class AbstractBaseEntity extends AbstractBaseBean {

	private static final long serialVersionUID = 8134802399225895500L;

	public abstract Long getId();

	@Override
	public int hashCode() {
		Long id = getId();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// nao pode ser == por causa do proxy Javassist!
		if (!getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}

		final AbstractBaseEntity other = (AbstractBaseEntity) obj;
		Long id = getId();
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Long id = getId();
		StringBuilder s = new StringBuilder();
		s.append(getClass().getName()).append("[id = ").append(id).append(" ]");
		return s.toString();
	}
}
