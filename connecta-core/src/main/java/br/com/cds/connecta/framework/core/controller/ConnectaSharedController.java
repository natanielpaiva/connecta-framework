package br.com.cds.connecta.framework.core.controller;

import br.com.cds.connecta.framework.core.bean.message.MessageModel;
import br.com.cds.connecta.framework.core.business.aplicationService.IConnectaSharedIndexerService;
import br.com.cds.connecta.framework.core.controller.common.InitController;
import br.com.cds.connecta.framework.core.domain.MessageEnum;
import br.com.cds.connecta.framework.core.domain.MessageTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ConnectaSharedController extends InitController {

    @Autowired
    private IConnectaSharedIndexerService service;
    
    @RequestMapping(value = "index", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<MessageModel> index() {
        
        service.saveIndex();

        return new ResponseEntity<>(
            translate.getMsg(MessageEnum.OPERATION_SUCESS, MessageTypeEnum.INFO),
            HttpStatus.OK
        );
    }

}
