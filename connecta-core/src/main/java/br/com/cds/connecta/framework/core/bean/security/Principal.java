package br.com.cds.connecta.framework.core.bean.security;

import br.com.cds.connecta.framework.core.bean.common.AbstractBaseBean;

public class Principal extends AbstractBaseBean {

    private static final long serialVersionUID = -1471982361476937158L;

    private Long id;
    private String usuario;
    private Long domainId;
    private Long subDomainId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuairo) {
        this.usuario = usuairo;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getSubDomainId() {
        return subDomainId;
    }

    public void setSubDomainId(Long subDomainId) {
        this.subDomainId = subDomainId;
    }

}
