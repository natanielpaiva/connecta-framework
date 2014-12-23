
package br.com.cds.connecta.framework.core.exeception;



import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.domain.ExceptionEnum;
import br.com.cds.connecta.framework.core.util.LogUtil;

/**
 * @author Ryan.Thuin
 * 
 */
public class SystemException extends AbstractSystemException {


    /**
     *
     */
    private static final long serialVersionUID = 284247619908956410L;

    public SystemException(ExceptionEnum type) {
        super(type);
    }

    public SystemException(ExceptionEnum exceptionType, String key, Object... args) {
        this(ExceptionEnum.SYSTEM_ERROR);
        addMessageToThrow(key, args);
    }

    public SystemException(Throwable e) {
        super(ExceptionEnum.SYSTEM_ERROR, e);
        LogUtil.instace(getClass()).error(e);
    }
  
    public Message getMessageError() {
        if (getMessagesToThrow().isEmpty()) {
            return null;
        }

        return getMessagesToThrow().get(0);
    }

}
