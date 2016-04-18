package br.com.cds.connecta.framework.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Ryan Achilles de Thuin
 * @version 0.1
 */
public class UtilString {

    public static final String LINE_SEPARATOR = "\n---------------------------------------------------------------------------------------------------------------------\n";

    public static String right(String texto, int numeroDeCaracteres) {
        if (numeroDeCaracteres > texto.length()) {
            return texto.toString();
        }
        return texto.substring(texto.length() - numeroDeCaracteres);
    }

    public static String left(String texto, int numeroDeCaracteres) {
        if (numeroDeCaracteres > texto.length()) {
            return texto.toString();
        }
        return texto.substring(0, numeroDeCaracteres);
    }

    public static String removeAll(char c, String s) {
        String resposta;
        StringBuffer buffer = new StringBuffer(s);
        int pos = 0;
        while (pos < buffer.length()) {
            if (buffer.charAt(pos) == c) {
                buffer.deleteCharAt(pos);
            } else {
                pos = pos + 1;
            }
        }
        resposta = buffer.toString();
        return resposta;
    }

    // remove os ultimos caracteres da string
    public static String removeUltimosCaracteres(String s, int qtd) {
        StringBuffer buffer = new StringBuffer(s);
        int count = 0;

        while (count < qtd) {
            int length = buffer.length();
            System.out.println(buffer.charAt(length - 1));
            buffer.deleteCharAt(length - 1);
            count++;
        }
        return buffer.toString();
    }

    public static String trocaCaracter(String caracter, String texto) {
        StringBuffer retorno = new StringBuffer();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != caracter.charAt(0)) {
                retorno.append(texto.charAt(i));
            }
        }
        return retorno.toString();
    }

    public static String stringParaHtml(String string) {
        int beg = 0;
        int len;
        StringBuffer results = null;
        char[] orig = null;
        if (string == null) {
            return "";
        } else {
            len = string.length();
            for (int i = 0; i < len; ++i) {
                char c = string.charAt(i);
                switch (c) {
                    case 0:
                    case '&':
                    case '<':
                    case '>':
                    case '"':
                    case '\'':
                        if (results == null) {
                            orig = string.toCharArray();
                            results = new StringBuffer(len + 10);
                        }
                        if (i > beg) {
                            results.append(orig, beg, i - beg);
                        }
                        beg = i + 1;
                        switch (c) {
                            default: // case 0:
                                continue;
                            case '&':
                                results.append("&amp;");
                                break;
                            case '<':
                                results.append("&lt;");
                                break;
                            case '>':
                                results.append("&gt;");
                                break;
                            case '"':
                                results.append("&quot;");
                                break;
                            case '\'':
                                results.append("&acute;");
                                break;
                        }
                        break;
                }
            }
            if (results == null) {
                return string;
            } else {
                results.append(orig, beg, len - beg);
                return results.toString();
            }
        }
    }

    public static String concatena(String valor, int qtdVezes) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < qtdVezes; i++) {
            buffer.append(valor);
        }
        return buffer.toString();
    }

    public static String concatena(String primeiraString, String segundaString) {
        return concatena(primeiraString, segundaString, " ");
    }

    public static String concatena(String primeiraString, String segundaString,
            String separador) {
        StringBuffer buffer = new StringBuffer(
                getStringVaziaSeNula(primeiraString));
        if (!isEmptyString(segundaString)) {
            buffer.append(separador);
            buffer.append(segundaString);
        }
        return buffer.toString();
    }

    public static String getStringComPrimeiraLetraMaiuscula(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String removeTagsEParametros(String string) {
        return removeParametros(removeTags(string));
    }

    public static String removeTags(String string) {
        return removeItens(string, '<', '>');
    }

    public static String removeParametros(String string) {
        return removeItens(string, '[', ']');
    }

    public static String removeItens(String string, char marcaInicio,
            char marcaFim) {
        string = string.replaceAll("&nbsp;", "");
        StringBuffer sb = new StringBuffer("");
        int inicioSbstring = 0;
        int inicioTag = string.indexOf(marcaInicio);
        if (inicioTag == -1) {
            inicioTag = string.length();
        }
        while (inicioTag != -1) {
            sb.append(string.substring(inicioSbstring, inicioTag) + " ");
            inicioSbstring = string.indexOf(marcaFim, inicioSbstring) + 1;
            if (inicioSbstring > 0 && inicioSbstring <= string.length()) {
                inicioTag = string.indexOf(marcaInicio, inicioSbstring);
            } else {
                break;
            }
        }
        sb.append(string.substring(inicioSbstring, string.length()));
        return sb.toString();
    }

    public static String getString(Reader conteudo) {
        String resposta = new String();
        char buf[] = new char[64];
        int num;
        try {
            while ((num = conteudo.read(buf)) != -1) {
                for (int i = 0; i < num; i++) {
                    resposta += buf[i];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public static String getStringVaziaSeNula(String string) {
        if (string == null) {
            return "";
        }
        return string;
    }

    public static String removeEspacosExtrasEntrePalavras(String string) {
        if (string == null) {
            return string;
        }
        StringTokenizer st = new StringTokenizer(string, " ");
        StringBuffer saida = new StringBuffer();
        while (st.hasMoreTokens()) {
            saida.append(st.nextToken());
            if (st.hasMoreTokens()) {
                saida.append(' ');
            }
        }
        return saida.toString();
    }

    public static String getNumeroRomano(int numero) {
        if (numero <= 0 || numero > 999) {
            throw new IllegalArgumentException(
                    "N�o � poss�vel converter o n�mero " + numero
                    + " para romano.");
        }

        String romano = "";
        int centena = getNumeroPosicao(numero, 2);
        switch (centena) {
            case 0:
                romano += "";
                break;
            case 1:
                romano += "C";
                break;
            case 2:
                romano += "CC";
                break;
            case 3:
                romano += "CCC";
                break;
            case 4:
                romano += "CD";
                break;
            case 5:
                romano += "D";
                break;
            case 6:
                romano += "DC";
                break;
            case 7:
                romano += "DCC";
                break;
            case 8:
                romano += "DCCC";
                break;
            case 9:
                romano += "CM";
                break;
        }

        int dezena = getNumeroPosicao(numero, 1);
        switch (dezena) {
            case 0:
                romano += "";
                break;
            case 1:
                romano += "X";
                break;
            case 2:
                romano += "XX";
                break;
            case 3:
                romano += "XXX";
                break;
            case 4:
                romano += "XL";
                break;
            case 5:
                romano += "L";
                break;
            case 6:
                romano += "LX";
                break;
            case 7:
                romano += "LXX";
                break;
            case 8:
                romano += "LXXX";
                break;
            case 9:
                romano += "XC";
                break;
        }

        int unidade = getNumeroPosicao(numero, 0);
        switch (unidade) {
            case 0:
                romano += "";
                break;
            case 1:
                romano += "I";
                break;
            case 2:
                romano += "II";
                break;
            case 3:
                romano += "III";
                break;
            case 4:
                romano += "IV";
                break;
            case 5:
                romano += "V";
                break;
            case 6:
                romano += "VI";
                break;
            case 7:
                romano += "VII";
                break;
            case 8:
                romano += "VIII";
                break;
            case 9:
                romano += "IX";
                break;
        }
        return romano;
    }

    protected static int getNumeroPosicao(int numero, int i) {
        String texto = Integer.toString(numero);
        String invertido = "";
        for (int j = texto.length() - 1; j >= 0; j--) {
            invertido += texto.charAt(j);
        }
        if (invertido.length() > i) {
            String numeroPosicao = invertido.charAt(i) + "";
            return Integer.parseInt(numeroPosicao);
        }
        return -1;
    }

    public static boolean isEmptyString(String string) {
        return string == null || string.trim().equals("");
    }

    public static String getUltimoSimbolo(String string, String delim) {
        int i = string.lastIndexOf(delim);
        if (i != -1) {
            return string.substring(i + 1, string.length());
        }
        return string;
    }

    public static String agruparVolume(List<?> lista) {

        String retorno = "";

        int nrVolume = 0;
        int nrPosicao = 0;
        int nrVolumeAnterior = 0;
        boolean guardando = false;

        Iterator<?> valores = lista.iterator();
        while (valores.hasNext()) {
            String volume = (String) valores.next();
            nrVolume = getNumeroDecimalDeRomano(volume);

            if (nrPosicao == 0) {
                retorno = volume;
                nrVolumeAnterior = nrVolume;
            } else {
                if ((nrVolume) == (nrVolumeAnterior + 1)) {
                    guardando = true;
                } else if ((nrVolume) > (nrVolumeAnterior + 1)) {
                    if (guardando) {
                        retorno = retorno + " a "
                                + getNumeroRomano(nrVolumeAnterior);
                        retorno = retorno + ", " + getNumeroRomano(nrVolume);
                        guardando = false;
                    } else {
                        retorno = retorno + ", " + getNumeroRomano(nrVolume);
                    }
                }
                nrVolumeAnterior = nrVolume;
            }
            nrPosicao++;
        }
        if (guardando) {
            retorno = retorno + " a " + getNumeroRomano(nrVolume);
        }

        return retorno;
    }

    public static int getNumeroDecimalDeRomano(String numeroRomano) {
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};

        String ro;
        int longitude;
        int retorno = 0;

        numeroRomano = numeroRomano.toUpperCase();

        for (int i = 0; i < 13; i++) {
            longitude = romanos[i].length();
            if (numeroRomano.length() >= longitude) {
                ro = numeroRomano.substring(0, longitude);
            } else {
                ro = "";
            }

            while ((numeroRomano.length() > 0) && (ro.equals(romanos[i]))) {
                numeroRomano = numeroRomano.substring(longitude,
                        numeroRomano.length());
                retorno = retorno + numeros[i];
                if (numeroRomano.length() >= longitude) {
                    ro = numeroRomano.substring(0, longitude);
                }
            }
        }
        return retorno;
    }

    /**
     * Preenche caracteres a direita da string Retorno: String
     */
    public static String rightPad(String valueToPad, String filler, int size) {
        if (valueToPad == null) {
            valueToPad = "";
        }
        while (valueToPad.length() < size) {
            valueToPad = valueToPad + filler;
        }
        if (valueToPad.length() > size) {
            valueToPad = valueToPad.substring(0, size);
        }

        return valueToPad;
    }

    /**
     * Preenche caracteres a esquerda da string Retorno: String
     */
    public static String leftPad(String valueToPad, String filler, int size) {
        if (valueToPad == null) {
            valueToPad = "";
        }
        while (valueToPad.length() < size) {
            valueToPad = filler + valueToPad;
        }
        if (valueToPad.length() > size) {
            valueToPad = valueToPad.substring(0, size);
        }

        return valueToPad;
    }

    public static String chrEspaco() {
        return String.valueOf((char) 32);
    }

    public static String completa_zeros_a_esquerda(String strNumero,
            int quantidadeZeros) {
        for (int n = strNumero.length(); n < quantidadeZeros; n++) {
            strNumero = "0" + strNumero;
        }
        return strNumero;

    }

    public static String completaBarraFinal(String diretorio) {
        if (diretorio != null) {
			// TarefaLogger.log("StringUtilitario:: Completando a barra final: "+
            // diretorio, "INFO");
            if (diretorio.endsWith("/")) {
				// TarefaLogger.log(
                // "StringUtilitario:: diretorio com a barra final: "+diretorio,
                // "INFO");
                return diretorio;
            }
        } else {

            System.out
                    .println("Diretorio de n�o foi encontrado na tabela Parametros.");
        }
        return diretorio + "/";
    }

    public static String completa_espacos_em_branco(
            int quantidadeEspacosEmBranco) {
        StringBuffer espacos = new StringBuffer();
        for (int i = 0; i < quantidadeEspacosEmBranco; i++) {
            espacos.append(' ');
        }
        return espacos.toString();
    }

    public static boolean isObjetoPreenchido(Object campo) {
        return ((campo != null) && (!campo.toString().trim().equals("")));
    }

    public static boolean isObjetoNaoPreenchido(Object campo) {
        return ((campo == null) || (campo.toString().trim().equals("")));
    }

    public static String converteParaPadraoPortugues(String valor) {
        valor = removeAll(',', valor);
        valor = valor.replace('.', ',').trim();
        return valor;
    }

    /**
     *
     * Elimina caracteres num�ricos
     *
     * @return String
     */
    public static String delNumber(String str) {

        String outStr = "";

        if (str == null) {
            return "";
        } else {
            str = str.trim();
        }

        for (int i = 0; i < str.length(); i++) {

            if (!isNumber(str.substring(i, i + 1))) {
                outStr += str.charAt(i);
            }

        }

        return outStr.trim();

    }

    /**
     * Verifica se string � num�rica Retorno: Boolean
     */
    public static boolean isNumber(String s) {

        if (s == null || (s.equals(""))) {
            return false;
        }

        String validChars = "0123456789";
        boolean isNumber = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (validChars.indexOf(c) == -1) {
                isNumber = false;
                break;
            } else {
                isNumber = true;
            }

        }

        return isNumber;

    }

    /**
     * Verifica se string n�o cont�m n�meros Retorno: Boolean
     */
    public static boolean isNotNumber(String s) {

        if (s == null || (s.equals(""))) {
            return false;
        }

        String validChars = "0123456789";
        boolean isNotNumber = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (validChars.indexOf(c) == -1) {
                isNotNumber = true;
            } else {
                isNotNumber = false;
                break;
            }

        }

        return isNotNumber;

    }

    /**
     *
     * Elimina zeros a esquerda de uma strins
     *
     * @return boolean
     */
    public static String delZeroEsquerda(String str) {

        String outStr = "";
        boolean flagFinishZero = false;

        if (str == null) {
            return "";
        } else {
            str = str.trim();
        }

        for (int i = 0; i < str.length(); i++) {

            if (!str.substring(i, i + 1).equals("0")) {
                flagFinishZero = true;
            }

            if (flagFinishZero == true) {
                outStr += str.charAt(i);
            }

        }

        return outStr;

    }

    /**
     *
     * Retira todos os espa�os da String
     *
     * @return String
     */
    public static String trimAll(String inStr) {

        if (inStr == null) {
            return "";
        }

        return replaceAll(inStr, " ", "");

    }

    /**
     * Troca uma string fixa por outra string fixa.
     *
     * @param A string original.
     * @param oldString A string fixa (nao padrao!) a ser procurada.
     * @param newString A string que substitui oldString.
     * @return A string com as instancias de oldString trocadas por newString.
     */
    public static String replaceAll(String s, String oldString, String newString) {

        if (oldString == null || oldString.length() == 0) {
            return s;
        }

        if (newString == null) {
            newString = "";
        }

        StringBuffer sb = new StringBuffer(s); // -- Retorno
        int posS, posS2; // -- Posi��o em s
        int posSb; // -- Posi��o em sb
        int sLength = s.length();
        int oldStringLength = oldString.length();
        int newStringLength = newString.length();

        posS = 0;
        posSb = 0;

        while (posS >= 0 && posS < sLength) {
            posS2 = s.indexOf(oldString, posS);
            if (posS2 >= 0) {
                posSb += posS2 - posS;
                sb.replace(posSb, posSb + oldStringLength, newString);
                posS2 += oldStringLength;
                posSb += newStringLength;
            }
            posS = posS2;
        }
        return sb.toString();
    }

    /**
     *
     * Elimina caracteres n�o num�ricos
     *
     *
     * @return String
     */
    public static String delNotNumber(String str) {

        String outStr = "";

        if (str == null) {
            return "";
        } else {
            str = str.trim();
        }

        for (int i = 0; i < str.length(); i++) {

            if (isNumber(str.substring(i, i + 1))) {
                outStr += str.charAt(i);
            }

        }

        return outStr;
    }

    /**
     *
     * Obt�m a quantidade de palavras que tem uma string
     *
     * @param String - String contendo as palavras
     * @return Quantidade de palavras
     * @exception Exception - Exception
     * @see Strings
     */
    public static int qtdPalavras(String inStr) throws Exception {

        int qtdPalavras = 0;

        if (inStr == null || inStr.trim().equals("")) {

            qtdPalavras = 0;

        } else {

            inStr = delEspacoExc(inStr);
            qtdPalavras = split(inStr, String.valueOf((char) 32)).size();

        }

        return qtdPalavras;

    }

    /**
     *
     * Elimina espa�os excessivos
     *
     *
     * @return boolean
     */
    public static String delEspacoExc(String str) {

        String outStr = "";
        int countEsp = 0;

        if (str == null) {
            return "";
        } else {
            str = str.trim();
        }

        for (int i = 0; i < str.length(); i++) {

            if (str.substring(i, i + 1).equals(" ")) {
                countEsp++;
            } else {
                countEsp = 0;
            }

            if (countEsp <= 1) {
                outStr += str.charAt(i);
            }

        }

        return outStr;

    }

    /**
     * Divide String em um Array de acordo com o caracter de separa��o Retorno:
     * Vector
     */
    public static Vector split(String str, String spltr) {

        Vector v = new Vector();
        boolean ok = true;

        int indx1 = 0;
        int indx2 = 0;

        str = str.trim();

        while (ok) {
            indx2 = str.indexOf(spltr, indx1);
            if (indx2 != -1) {
                v.addElement(str.substring(indx1, indx2));
                indx1 = indx2 + 1;
            } else {
                ok = false;
            }
        }

        v.addElement(str.substring(indx1, str.length()));

        return v;
    }

    /**
     * Retira acentos
     *
     * @param String s
     * @return String
     */
    public static String retiraAcento(String s) {

        String PLAIN_ASCII = "AaEeIiOoUu" // grave
                + "AaEeIiOoUuYy" // acute
                + "AaEeIiOoUuYy" // circumflex
                + "AaEeIiOoUuYy" // tilde
                + "AaEeIiOoUuYy" // umlaut
                + "Aa" // ring
                + "Cc" // cedilla
                + "aa";

        String UNICODE = "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
                + "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
                + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
                + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
                + "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF"
                + "\u00C5\u00E5" + "\u00C7\u00E7" + "\u00E3\u0061";

        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int pos = UNICODE.indexOf(c);
            if (pos > -1) {
                sb.append(PLAIN_ASCII.charAt(pos));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    /**
     * Troca uma palavra por outra.
     *
     * @param A string original.
     * @param oldString A string fixa (nao padrao!) a ser procurada.
     * @param newString A string que substitui oldString.
     * @return A string com as instancias de oldString trocadas por newString.
     */
    public static String replacePalavra(String s, String oldString,
            String newString) {

        if (s == null) {
            return s;
        }

        if (oldString == null || oldString.length() == 0) {
            return s;
        }

        if (newString == null) {
            newString = "";
        }

        boolean flagReplace = false;
        String outStr = "";
        String tmpStr = "";

        // s = delEspacoExc(s);
        Vector arrayStr = new Vector();
        arrayStr = split(s, " ");

        for (int i = 0; i < arrayStr.size(); i++) {

            tmpStr = "";
            flagReplace = false;

            for (int i2 = i; i2 < arrayStr.size(); i2++) {

                tmpStr += arrayStr.get(i2);

                if (tmpStr.equals(trimAll(oldString))) {
                    tmpStr = replaceAll(tmpStr, trimAll(oldString), newString);
                    flagReplace = true;
                    i = i2;
                    break;
                }

            }

            if (flagReplace == false) {
                tmpStr = arrayStr.get(i).toString();
            }

            outStr += tmpStr + " ";

        }

        return outStr.trim();

    }

    public static String formataTexto(String texto) throws IOException {
        StringReader reader = new StringReader(texto);
        BufferedReader bf = new BufferedReader(reader);
        String line;
        StringWriter sw = new StringWriter();
        while ((line = bf.readLine()) != null) {
            line = line.trim(); // remove leading and trailing whitespace
            if (!line.equals("")) // don't write out blank lines
            {
                // line
                sw.write(line, 0, line.length());
                //sw.append('\n');

            }
        }
        return sw.toString();
    }

    public static int parseInt(String value) {
        String oth = soNumero(value);

        if (!(value == null || value.replaceAll("\\D", "").trim().length() == 0)) {
            return Integer.parseInt(oth);
        }
        return 0;
    }

    public static String soNumero(String valor) {
        if (!(valor == null || valor.trim().length() == 0)) {
            return valor.replaceAll("[\\D{[^0-9]}]", "").trim();
        }
        return valor;
    }

    public static String removeCaracteresEspeciais(String valor) {
        return valor.replaceAll("[!@#$%¨&*(){}\\[\\]<>^~.,:;\\/\\| ]*", "").trim();
    }

}
