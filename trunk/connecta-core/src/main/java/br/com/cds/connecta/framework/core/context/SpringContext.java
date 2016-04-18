package br.com.cds.connecta.framework.core.context;

import br.com.cds.connecta.framework.core.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.google.cloud.sql.jdbc.internal.Util;
/**
 *
 * @author Ryan Achilles de Thuin
 * @since 10/01/2014
 * @version 0.1
 */
public class SpringContext {

    private ApplicationContext context;

    private SpringContext() {
        context = new ClassPathXmlApplicationContext(
                new String[]{"spring/applicationContext.xml"});
    }

    private static SpringContext instance;

    public static SpringContext getInstance() {
        if (SpringContext.instance == null) {
            synchronized (SpringContext.class) {
                if (SpringContext.instance == null) {
                    SpringContext.instance = new SpringContext();
                }
            }
        }
        return SpringContext.instance;
    }

    public ApplicationContext getContext() {
        return this.context;
    }

    public Object getBean(String name) {
        if (!Util.isEmpty(name)) {
            return this.context.getBean(name);
        }
        throw new IllegalArgumentException("Nome do bean não informado");
    }

    public Object getBean(Class<?> classe) {
        if (classe != null) {
            return this.context.getBean(classe);
        }
        throw new IllegalArgumentException("Classe do bean não informado");
    }
}
