package br.com.cds.connecta.framework.core.domain;

/**
 * Enum de tipos de mensagens das aplicações
 */
public enum MessageTypeEnum {

    /**
     * Mensagens informativas que exibem o progresso da execução da aplicação
     */
    INFO,
    /**
     * Permite informar situações potencialmente nocivas
     */
    WARN,
    /**
     * Informa sobre eventos que não permite a continuação da execução de uma
     * funcionalidade
     */
    ERROR
}
