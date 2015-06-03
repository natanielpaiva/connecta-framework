package br.com.cds.connecta.framework.core.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    
    public static boolean isNotEmpty(Collection<?> collection) {
        return !(isNull(collection) || collection.isEmpty());
    }
    
    public static boolean isNotNull(Object s) {
        return !(s == null);
    }

    /**
     * Metodo para verificar caso a lista seja null e retornar uma lista vazia.
     * Utilizado em for each's (enhanced for) para evitar NullPointerException's
 em getList()'s que retornam null.
 Ex.: 
 for(Object obj : checkEmpty(getMyObjList()){}
     * 
     * @param <E>
     * @param list
     * @return 
     */
    public static <E> List<E> checkEmpty(List<E> list) {
        return list == null ? Collections.<E>emptyList() : list;
    }

}
