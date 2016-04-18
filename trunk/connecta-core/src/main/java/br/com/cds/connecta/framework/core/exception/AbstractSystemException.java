package br.com.cds.connecta.framework.core.exception;

import java.util.ArrayList;
import java.util.List;

import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.domain.MessageEnum;

public abstract class AbstractSystemException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -5270792712405112397L;

    private MessageEnum exceptionType;
    private List<Message> messagesToThrow = new ArrayList<>();

    public AbstractSystemException(MessageEnum type) {
        super(type.name());
        exceptionType = type;
    }

    public AbstractSystemException(MessageEnum type, Throwable e) {
        super(type.name(), e);
    }

    public AbstractSystemException(MessageEnum type, String key, Object... args) {
        super(type.name());
        addMessageToThrow(key, args);
    }

    public AbstractSystemException(MessageEnum type, String key, String message, Object... args) {
        super(type.name());
        addMessageToThrow(key, message, args);
    }

    /**
     * Adiciona uma mensagem sem o texto explicativo
     *
     * @param key chave de mensagem
     * @param args arguemntos para formtação da mensagem
     */
    protected void addMessageToThrow(String key, Object... args) {
        messagesToThrow.add(new Message(key, args));
    }

    /**
     * Adiciona uma mensagem com o texto explicativo
     *
     * @param key chave de mensagem
     * @param message texto informativo
     * @param args argumentos para formatação da mensagem
     */
    protected void addMessageToThrow(String key, String message, Object... args) {
        messagesToThrow.add(new Message(key, message, args));
    }

    protected List<Message> getMessagesToThrow() {
        return messagesToThrow;
    }

    public MessageEnum getExceptionEnum() {
        return exceptionType;
    }

}
