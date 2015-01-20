package br.com.cds.connecta.framework.core.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public class UtilMap {

    public static String getString(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return mapa.get(chave).toString();
            }
        }
        return null;
    }

    public static Integer getInteger(Map<?, ?> mapa, String chave) {

        try {
            if (mapa.containsKey(chave)) {
                if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                    return Integer.parseInt(mapa.get(chave).toString());
                }
            }

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Double getDouble(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return Double.parseDouble(mapa.get(chave).toString());
            }
        }
        return null;
    }

    public static BigDecimal getBigDecimal(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return new BigDecimal(mapa.get(chave).toString());
            }
        }
        return null;
    }

    public static BigInteger getBigInteger(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return new BigInteger(mapa.get(chave).toString());
            }
        }
        return null;
    }

    public static Long getLong(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return Long.parseLong(mapa.get(chave).toString());
            }
        }
        return null;
    }

    public static Boolean getBoolean(Map<?, ?> mapa, String chave) {
        if (mapa.containsKey(chave)) {
            if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                return Boolean.parseBoolean((mapa.get(chave).toString()));
            }
        }
        return null;
    }

    public static Date getDate(Map<?, ?> mapa, String chave) {
        try {
            if (mapa.containsKey(chave)) {
                if (UtilString.isObjetoPreenchido(mapa.get(chave))) {
                    return UtilDate.getData(mapa.get(chave).toString());
                }
            }
        } catch (ParseException e) {
            try {
                return UtilDate.getDataHora(mapa.get(chave).toString());
            } catch (ParseException e1) {
                try {
                    return UtilDate.getDataHoraMilesimo(mapa.get(chave).toString());
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

}
