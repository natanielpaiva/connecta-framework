package br.com.cds.connecta.framework.core.domain;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Interface Utilitária para os nomes de escopos dos Beans do Spring
 *
 * @author Julio Lemes
 * @date Aug 13, 2015
 *
 * @see
 * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
 * Bean Scopes</a>
 */
public interface SpringBeanScope {

    /**
     * Scope identifier for the standard singleton scope: "singleton".
     *
     * @see
     * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
     * Bean Scopes</a>
     */
    String SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    /**
     * Scope identifier for the standard prototype scope: "prototype".
     *
     * @see
     * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
     * Bean Scopes</a>
     */
    String PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    /**
     * Scope identifier for the standard singleton scope: "request".
     *
     * @see
     * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
     * Bean Scopes</a>
     */
    String REQUEST = "request";

    /**
     * Scope identifier for the standard prototype scope: "session".
     *
     * @see
     * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
     * Bean Scopes</a>
     */
    String SESSION = "session";

    /**
     * Scope identifier for the standard prototype scope: "global-session".
     *
     * @see
     * <a href="http://www.tutorialspoint.com/spring/spring_bean_scopes.htm">Spring
     * Bean Scopes</a>
     */
    String GLOBAL_SESSION = "global-session";

}
