package br.com.cds.connecta.framework.core.util;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class LogUtil {

	private Log logger;

	LogUtil(Class<?> clazz) {
		logger = LogFactory.getLog(clazz);
	}

	public static LogUtil instace(Class<?> clazz){
		return new LogUtil(clazz);
	}

	public void info(String text, Object... args){
		logger.info(MessageFormat.format(text, args));
	}

	public void warn(String text, Object... args){
		logger.warn(MessageFormat.format(text, args));
	}

	public void warn(String text, Throwable e, Object... args){
		logger.warn(MessageFormat.format(text, args), e);
	}

	public void error(Throwable e){
		logger.error(e.getMessage(), e);
	}

	public void error(String text, Throwable e, Object... args){
		logger.error(MessageFormat.format(text, args), e);
	}

}
