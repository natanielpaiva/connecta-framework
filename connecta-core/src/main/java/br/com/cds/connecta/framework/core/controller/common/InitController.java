package br.com.cds.connecta.framework.core.controller.common;

import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.bean.message.MessageModel;
import br.com.cds.connecta.framework.core.bean.message.TranslateMessage;
import br.com.cds.connecta.framework.core.domain.MessageEnum;
import br.com.cds.connecta.framework.core.exception.BusinessException;
import br.com.cds.connecta.framework.core.exception.SystemException;

public abstract class InitController {

    @Autowired
    protected TranslateMessage translate;

    /**
     * add uma notificacao de erro ao request
     *
     * @param e
     */
    public void addErroRequest(BusinessException e) {
        for (Message msg : e.getMessages()) {
            addErroRequest(msg.getKey(), msg.getParams());
        }
    }

    /**
     * add uma notificacao de erro ao request
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     */
    public void addErroRequest(String key, Object... args) {
        putMessageRequest(getMsgErro(key, args));
    }

    /**
     * add uma notificacao de info ao request
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     */
    public void addInfoRequest(String key, Object... args) {
        putMessageRequest(getMsgInfo(key, args));
    }

    /**
     * add uma notificacao de alerta ao request
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     */
    public void addAlertaRequest(String key, Object... args) {
        putMessageRequest(getMsgAlerta(key, args));
    }

    /**
     * Traduz a chave com os parametros para uma mensagem mapeada no arquivo de
     * messages
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     * @return {@link MessageModel} com tipo {@link MessageType#ERROR}
     */
    protected MessageModel getMsgErro(String key, Object... args) {
        return translate.getMsg(key, MessageEnum.ERROR, args);
    }

    /**
     * Traduz a chave com os parametros para uma mensagem mapeada no arquivo de
     * messages
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     * @return {@link MessageModel} com tipo {@link MessageType#INFO}
     */
    protected MessageModel getMsgInfo(String key, Object... args) {
        return translate.getMsg(key, MessageEnum.INFO, args);
    }

    /**
     * Traduz a chave com os parametros para uma mensagem mapeada no arquivo de
     * messages
     *
     * @param key chave da mensagem contida no arquivo properties
     * @param args parametros para formatar mensagem
     * @return {@link MessageModel} com tipo {@link MessageType#WARN}
     */
    protected MessageModel getMsgAlerta(String key, Object... args) {
        return translate.getMsg(key, MessageEnum.WARN, args);
    }

    @SuppressWarnings("unchecked")
    protected void putMessageRequest(MessageModel message) {

        ServletRequestAttributes servletRequest = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();
        List<MessageModel> notificatios = (List<MessageModel>) servletRequest
                .getAttribute("notifications", RequestAttributes.SCOPE_REQUEST);
        if (notificatios == null) {
            notificatios = new ArrayList<MessageModel>();
            servletRequest.setAttribute("notifications", notificatios,
                    RequestAttributes.SCOPE_REQUEST);
        }

        notificatios.add(message);
    }

    @ExceptionHandler({BusinessException.class})
    public Object handleException(BusinessException e,
            HttpServletResponse response) {
        addErroRequest(e);
        return null;
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(Throwable e,
            HttpServletResponse response) {
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        SystemException system;
        if (SystemException.class == e.getClass()) {
            system = (SystemException) e;
        } else {
            system = new SystemException(e);
        }

        MessageModel msgVO = translate.getMsg(system.getMessage(),
                MessageEnum.ERROR);

        ModelAndView model = new ModelAndView("500");
        model.addObject("msgVO", msgVO);
        model.addObject("trace", system.getStackTrace());
        return model;
    }

}
