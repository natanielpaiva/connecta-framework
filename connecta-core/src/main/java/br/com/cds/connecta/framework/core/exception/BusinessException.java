package br.com.cds.connecta.framework.core.exception;

import java.util.List;

import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.domain.MessageEnum;

/**
 * @author Ryan A. Thuin
 */
public class BusinessException extends SystemException {

    private static final long serialVersionUID = -1407096377889948070L;

    public BusinessException(MessageEnum exceptionType) {
        super(exceptionType);
    }

    public BusinessException(MessageEnum exceptionType, String key, Object... args) {
        this(exceptionType);
        addMessage(key, args);
    }

    public void addMessage(String key, Object... args) {
        super.addMessageToThrow(key, args);
    }

    public List<Message> getMessages() {
        return super.getMessagesToThrow();
    }

}
