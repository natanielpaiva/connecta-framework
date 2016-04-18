package br.com.cds.connecta.framework.core.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation utilizada pelo SecurityConnector para identificar recursos(urls) que
 * deverão ser de acesso público
 * @author Julio Lemes
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PublicResource {}
