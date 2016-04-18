package br.com.cds.connecta.framework.core.exception;

import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.domain.MessageEnum;
import br.com.cds.connecta.framework.core.util.LogUtil;

/**
 * @author Ryan.Thuin
 *
 */
public class SystemException extends AbstractSystemException {

    private static final long serialVersionUID = 284247619908956410L;

    public SystemException(MessageEnum type) {
        super(type);
    }

    public SystemException(MessageEnum exceptionType, String key, Object... args) {
        this(MessageEnum.SYSTEM_ERROR);
        addMessageToThrow(key, args);
    }

    public SystemException(Throwable e) {
        super(MessageEnum.SYSTEM_ERROR, e);
        LogUtil.instace(getClass()).error(e);
    }

    public Message getMessageError() {
        if (getMessagesToThrow().isEmpty()) {
            return null;
        }

        /**
         * FIXME Só uma?
         */
        return getMessagesToThrow().get(0);
    }

}
