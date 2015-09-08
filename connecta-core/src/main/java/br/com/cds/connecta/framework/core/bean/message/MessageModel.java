package br.com.cds.connecta.framework.core.bean.message;


import br.com.cds.connecta.framework.core.bean.common.AbstractBaseBean;
import br.com.cds.connecta.framework.core.domain.MessageEnum;
import br.com.cds.connecta.framework.core.domain.MessageTypeEnum;

public class MessageModel extends AbstractBaseBean {

    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private MessageTypeEnum type = MessageTypeEnum.INFO;

    public MessageModel() {
    }

    public MessageModel(String code, String message, MessageTypeEnum tipo) {
        super();
        this.code = code;
        this.message = message;
        this.type = tipo;
    }
    
    public MessageModel(MessageEnum code, String message, MessageTypeEnum tipo) {
        super();
        this.code = code.name();
        this.message = message;
        this.type = tipo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

}
