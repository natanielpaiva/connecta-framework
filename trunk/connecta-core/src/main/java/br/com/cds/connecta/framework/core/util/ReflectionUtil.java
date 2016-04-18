package br.com.cds.connecta.framework.core.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class ReflectionUtil {
	
	private ReflectionUtil(){
		
	}
	
	private static String capitilize(String text) {
	    if (text == null)
	      return null;
	    if (text.length() == 0)
	      return text;
	    String result = text.substring(0, 1).toUpperCase(Locale.ENGLISH);
	    if (text.length() > 1)
	      result += text.substring(1);
	    return result;
	}
	
	private static Method findMethod(Class<?> clazz, String methodName){
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName))
				return method;
		}
		
	    return null;
	}
	
	public static void set(Object instance, String property, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		String methodName = "set" + capitilize(property);		
		Method method = findMethod(instance.getClass(),methodName);		
		Object[] parameters = new Object[] { value };
		
		method.invoke(instance, parameters);
				
	}
	
	public static Object get(Object instance, String property) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		String methodName = "get" + capitilize(property);		
		Method method = findMethod(instance.getClass(),methodName);
		
		return method.invoke(instance, null);
			
	}

}
