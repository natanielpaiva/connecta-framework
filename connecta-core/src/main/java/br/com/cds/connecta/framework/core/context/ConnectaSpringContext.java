package br.com.cds.connecta.framework.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 *
 * @author Julio Lemes
 */
@Component
public class ConnectaSpringContext extends ApplicationObjectSupport {

    private static ApplicationContext context;

    @Override
    protected boolean isContextRequired() {
        return true;
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        ConnectaSpringContext.context = context;
    }
    
    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <E> E getBean(Class<E> beanClass) {
        return context.getBean(beanClass);
    }

}