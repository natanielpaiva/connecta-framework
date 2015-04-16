package br.com.cds.connecta.framework.core.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cds.connecta.framework.core.bean.message.Message;
import br.com.cds.connecta.framework.core.bean.message.MessageModel;
import br.com.cds.connecta.framework.core.bean.message.TranslateMessage;
import br.com.cds.connecta.framework.core.domain.MessageEnum;
import br.com.cds.connecta.framework.core.exception.BusinessException;
import br.com.cds.connecta.framework.core.exception.SystemException;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public abstract class InitController {

    @Autowired
    protected TranslateMessage translate;

    /**
     * Traduz a chave com os parametros para uma mensagem mapeada no arquivo de
     * mensagens
     *
     * @param key
     * @param messageEnum
     * @param args
     * @return
     */
    protected MessageModel getTranslatedMessage(String key, MessageEnum messageEnum, Object... args) {
        return translate.getMsg(key, messageEnum, args);
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleException(BusinessException e) {
        List<MessageModel> messageModels = new ArrayList<>();

        for (Message message : e.getMessages()) {
            messageModels.add(getTranslatedMessage(message.getMessage(), MessageEnum.ERROR));
        }

        return new ResponseEntity(messageModels, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        IllegalArgumentException.class,
        IllegalStateException.class
    })
    public ResponseEntity handleException(Exception e) {
        MessageModel mm = getTranslatedMessage(e.getMessage(), MessageEnum.WARN);

        return new ResponseEntity(mm, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        MethodArgumentNotValidException.class
    })
    public ResponseEntity handleException(MethodArgumentNotValidException e) {
        List<MessageModel> mms = new ArrayList<>();

        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            mms.add(getTranslatedMessage(error.getDefaultMessage(), MessageEnum.WARN));
        }

        return new ResponseEntity(mms, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException(Throwable e) {
        if (ExceptionUtils.getRootCause(e) instanceof ConstraintViolationException) {
            ;
        }

        SystemException system;
        if (e instanceof SystemException) {
            system = (SystemException) e;
        } else {
            system = new SystemException(e);
        }

        e.printStackTrace();

        MessageModel mm = translate.getMsg(system.getMessage(), MessageEnum.ERROR);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(mm, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
