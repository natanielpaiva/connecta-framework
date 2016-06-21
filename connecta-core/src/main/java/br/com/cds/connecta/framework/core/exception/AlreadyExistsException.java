package br.com.cds.connecta.framework.core.exception;

import br.com.cds.connecta.framework.core.domain.MessageEnum;

public class AlreadyExistsException extends SystemException {

    private static final long serialVersionUID = 1L;

    private final String fieldName;
    private final String resourceName;

    public AlreadyExistsException(String resourceName, String fieldName) {
        super(MessageEnum.CONFLICT);

        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getResourceName() {
        return resourceName;
    }

}
