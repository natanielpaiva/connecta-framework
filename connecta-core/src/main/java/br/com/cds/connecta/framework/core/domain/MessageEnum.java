package br.com.cds.connecta.framework.core.domain;

/**
 * Define as mensagens que as aplicaçoes podem retornar
 */
public enum MessageEnum {
    
    // Error messages
    SYSTEM_ERROR,
    REJECTED,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    CONFLICT,
    INTEGRITY_ERROR,
    FALID_CONNECTION,
    
    // Success messages
    OPERATION_SUCESS;

}
