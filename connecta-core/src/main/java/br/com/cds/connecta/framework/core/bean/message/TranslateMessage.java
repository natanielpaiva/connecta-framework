package br.com.cds.connecta.framework.core.bean.message;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import br.com.cds.connecta.framework.core.domain.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;

@Component
public class TranslateMessage {

    /**
     *
     */
    private static final long serialVersionUID = -7834720852460047555L;

    @Autowired
    protected ApplicationContext context;

    /**
     * Traduz a chave em mensagem com o locale informado. Locale padrão pt_BR
     *
     * @param key
     * @param locale (opcional)
     * @param args
     * @return
     */
    public String getTextMsg(String key, Locale locale, Object... args) {
        if (locale == null) {
            locale = new Locale("pt_BR");
        }

        try {
            return context.getMessage(key, args, locale);
        } catch (NoSuchMessageException e) {
            return key;
        }
    }

    /**
     * Traduz a chave em mensagem com o locale da sessao do usuario. Locale
     * padrão pt_BR
     *
     * @param key
     * @param type
     * @param args
     * @return
     */
    public MessageModel getMsg(String key, MessageEnum type, Object... args) {
        return getMsg(key, type, LocaleContextHolder.getLocale(), args);
    }

    /**
     * Traduz a chave em mensagem com o locale informado da sessao do usuario
     *
     * @param code
     * @param type
     * @param locale
     * @param args
     * @return
     */
    public MessageModel getMsg(String code, MessageEnum type, Locale locale, Object... args) {

        String message = getTextMsg(code, locale, args);

        MessageModel form = new MessageModel();
        form.setCode(code);
        form.setMessage(message);
        form.setType(type);

        return form;

    }
}
