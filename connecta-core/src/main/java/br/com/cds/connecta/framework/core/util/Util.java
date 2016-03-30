package br.com.cds.connecta.framework.core.util;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static boolean isEmpty(Map<?,?> map) {
        return (isNull(map) || map.isEmpty());
    }

    public static boolean isEmpty(String s) {
        return (isNull(s) || s.trim().equals("") || s.trim().equals("null"));
    }

    public static boolean isNotEmpty(String s) {
        return !((isNull(s) || s.trim().equals("") || s.trim().equals("null")));
    }

    public static boolean isNull(Object s) {
        return (s == null);
    }
    
    public static boolean isNotEmpty(Collection<?> collection) {
        return !(isNull(collection) || collection.isEmpty());
    }
    
    public static boolean isNotEmpty(Object[] array) {
        return (isNotNull(array) && array.length != 0);
    }
    
    public static boolean isNotNull(Object s) {
        return (s != null);
    }

    /**
     * Metodo para verificar caso a lista seja null e retornar uma lista vazia.
     * Utilizado em for each's (enhanced for) para evitar NullPointerException's
     * em getList()'s que retornam null.
     * Ex.: 
     * for(Object obj : checkEmpty(getMyObjList()){}
     * 
     * @param list informada para checar se é vazia ou não
     * @return 
     */
    public static <E> List<E> checkEmpty(List<E> list) {
        return list == null ? Collections.<E>emptyList() : list;
    }
    
    
    public static <E> Set<E> checkEmpty(Set<E> list) {
        return list == null ? Collections.<E>emptySet(): list;
    }

    /**
     * Remove os acentos das letras da string informada
     * 
     * @param string
     * @return 
     */
    public static String removeSpecialCharacters(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    
    /**
     * Remove os acentos, remove espaços em branco sobrando e coloca todas as
     * letras em caixa alta.
     * 
     * @param string a string a ser processada
     * @param addLike true para adicionar "%" antes e depois da string
     * @return 
     */
    public static String prepareForSearch(String string, boolean addLike) {
        String postfix = removeSpecialCharacters(string.trim().toUpperCase());
        
        if (addLike) {
            postfix = "%"+postfix+"%";
        }
        
        return postfix;
    }
}
