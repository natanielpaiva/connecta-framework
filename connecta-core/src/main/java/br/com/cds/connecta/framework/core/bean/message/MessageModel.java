package br.com.cds.connecta.framework.core.bean.message;


import br.com.cds.connecta.framework.core.bean.common.AbstractBaseBean;
import br.com.cds.connecta.framework.core.domain.MessageEnum;

public class MessageModel extends AbstractBaseBean {

    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private MessageEnum type = MessageEnum.INFO;

    public MessageModel() {
    }

    public MessageModel(String code, String message, MessageEnum tipo) {
        super();
        this.code = code;
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

    public MessageEnum getType() {
        return type;
    }

    public void setType(MessageEnum type) {
        this.type = type;
    }

}
