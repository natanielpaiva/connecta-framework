package br.com.cds.connecta.framework.core.exception;

import br.com.cds.connecta.framework.core.domain.MessageEnum;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ResourceNotFoundException extends SystemException {
    
    private final String resourceName;
    
    public ResourceNotFoundException(String resourceName) {
        super(MessageEnum.NOT_FOUND);
        
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

}
