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
import br.com.cds.connecta.framework.core.domain.MessageTypeEnum;
import br.com.cds.connecta.framework.core.exception.AlreadyExistsException;
import br.com.cds.connecta.framework.core.exception.BusinessException;
import br.com.cds.connecta.framework.core.exception.ResourceNotFoundException;
import br.com.cds.connecta.framework.core.exception.SystemException;
import java.sql.SQLException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class InitController {

    @Autowired
    protected TranslateMessage translate;

    private final Logger logger = Logger.getLogger(InitController.class);

    /**
     * Traduz a chave com os parametros para uma mensagem mapeada no arquivo de
     * mensagens
     *
     * @param key Chave da mensagem mapeada
     * @param messageEnum Tipo da mensagem SUCCESS, INFO, WARN e ERROR
     * @param args Args
     * @return MessageModel Objeto da mensagem
     */
    protected MessageModel getTranslatedMessage(String key, MessageTypeEnum messageEnum, Object... args) {
        return translate.getMsg(key, messageEnum, args);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MessageModel> handleException(ResourceNotFoundException e) {
        String translatedResourceName = translate.getTextMsg(e.getResourceName(), null);

        MessageModel message = getTranslatedMessage(e.getExceptionEnum().name(), MessageTypeEnum.ERROR,
                translatedResourceName);

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<MessageModel> handleException(AlreadyExistsException e) {
        String translatedResourceName = translate.getTextMsg(e.getResourceName(), null);
        String translatedFieldName = translate.getTextMsg(e.getFieldName(), null);

        MessageModel message = getTranslatedMessage(e.getExceptionEnum().name(), MessageTypeEnum.ERROR,
                translatedResourceName, translatedFieldName);

        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleException(BusinessException e) {
        List<MessageModel> messageModels = new ArrayList<>();

        for (Message message : e.getMessages()) {
            messageModels.add(getTranslatedMessage(message.getMessage(), MessageTypeEnum.ERROR));
        }

        return new ResponseEntity(messageModels, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        IllegalArgumentException.class,
        IllegalStateException.class,
        MissingServletRequestParameterException.class
    })
    public ResponseEntity handleException(Exception e) {
        MessageModel mm = getTranslatedMessage(e.getMessage(), MessageTypeEnum.WARN);

        return new ResponseEntity(mm, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        MethodArgumentNotValidException.class
    })
    public ResponseEntity handleException(MethodArgumentNotValidException e) {
        List<MessageModel> mms = new ArrayList<>();

        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            mms.add(getTranslatedMessage(error.getDefaultMessage(), MessageTypeEnum.WARN));
        }

        return new ResponseEntity(mms, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        DataIntegrityViolationException.class
    })
    public ResponseEntity handleException(DataIntegrityViolationException e) {
        MessageModel message = getTranslatedMessage(MessageEnum.INTEGRITY_ERROR.name(), MessageTypeEnum.WARN);

        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        SQLException.class
    })
    public ResponseEntity handleException(SQLException e) {
        MessageModel message = getTranslatedMessage(MessageEnum.FALID_CONNECTION.name(), MessageTypeEnum.ERROR);
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        ConstraintViolationException.class
    })
    public ResponseEntity handleException(ConstraintViolationException e) {
        List<MessageModel> mms = new ArrayList<>();

        for (ConstraintViolation violation : e.getConstraintViolations()) {
            MessageModel translatedMessage = getTranslatedMessage(MessageEnum.REJECTED.name(), MessageTypeEnum.WARN);

            translatedMessage.setMessage(violation.getMessage());

            mms.add(translatedMessage);
        }

        return new ResponseEntity(mms, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException(Throwable e) {
        SystemException system;
        if (e instanceof SystemException) {
            system = (SystemException) e;
        } else {
            system = new SystemException(e);
        }

        logger.error(system.getMessage(), system);

        MessageModel mm = translate.getMsg(system.getMessage(), MessageTypeEnum.ERROR);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(mm, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
