package br.com.cds.connecta.framework.core.util;

import java.util.Collection;

/**
 * 
 * 
 * @author Ryan A. Thuin
 * @version 1.0.0
 *
 */

public class Util {
    
    public static boolean isEmpty(Collection<?> collection) {
        return (isNull(collection) || collection.isEmpty());
    }
    
    public static boolean isEmpty(String s) {
        return (isNull(s) || s.trim().equals("") || s.trim().equals("null"));
    }
    
    public static boolean isNull(Object s) {
        return (s == null);
    }
    
}
