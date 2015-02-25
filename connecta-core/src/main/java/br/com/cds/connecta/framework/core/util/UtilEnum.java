
import br.com.cds.connecta.framework.core.bean.message.TranslateMessage;
import br.com.cds.connecta.framework.core.context.SpringContext;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 *
 * @author Julio Lemes
 * @date Feb 24, 2015
 */
public class UtilEnum {
    
    public static ObjectNode getEnumTranslation(String name) {
        ObjectNode node = getNode();
        node.put("name", name);
        
        TranslateMessage translator = (TranslateMessage) SpringContext.getInstance().getBean(TranslateMessage.class);

        String value = translator.getTextMsg(name, LocaleContextHolder.getLocale());
        node.put("value", value);

        return node;
    }

    public static ObjectNode getEnumObjectValue(String name, Integer index) {
        ObjectNode node = getNode();
        node.put("index", index);
        node.put("name", name);
        return node;
    }

    private static ObjectNode getNode() {
        return new ObjectNode(JsonNodeFactory.instance);
    }

}
