package br.com.cds.connecta.framework.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Classe de segurança utilitária
 */
public class SecurityUtil {

    public static String SHA_1 = "SHA-1";
    public static String SHA_256 = "SHA-256";
    public static String SHA_224 = "SHA-224";
    public static String SHA_384 = "SHA-384";
    public static String SHA_512 = "SHA-512";
    public static String MD5 = "MD5";

//    public static void main(String[] args) {
//
//        try {
//
//            //para gerar uma key fechada
//            String keyAberta = "cds-mira-2013-24";
//            String keyFechada = stringHexa(keyAberta.getBytes());
//
//            System.out.println("keyFechada=".concat(keyFechada));
//
//            //para gear um hash com base na key aberta
//            String hashAberto = "CDS$DOM1NU5R3X#2014-06-30 23:59:59";
//            String hashFechado = getCripto(hashAberto, keyAberta);
//
//            System.out.println("hashFechado".concat(hashFechado));
//
//	        //String hash = "37a86670c46c4a627b1257f2757f308a05125e0da1318eafbc935a5b2b719af9321b6f69c45fe29573197a0cfbdce9e2";
//            //String key = "6364732d6d6972612d323031332d3234";
//            //para descriptografar e recuperar o hash aberto
//            String clean = SecurityUtil.getDescriptoHexa(hashFechado, keyFechada);
//
//            System.out.println(clean);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    private SecurityUtil() {
    }

    /**
     * Gera um hash com base na frase e algoritmo informados.
     *
     * @param frase
     * @param algoritm
     * @return
     */
    public static String getHash(String frase, String algoritm, boolean random) {

        SimpleDateFormat sd = new SimpleDateFormat();
        sd.applyPattern("yyyy.MM.dd.HH.mm.ss");
        String strDate = sd.format(new Date());

        frase = strDate.concat(frase);

        return stringHexa(gerarHash(frase, algoritm));
    }

    /**
     * Gera um hash com base na frase e algoritmo informados.
     *
     * @param frase
     * @param algoritm
     * @return
     */
    public static String getHash(String frase, String algoritm) {
        return stringHexa(gerarHash(frase, algoritm));
    }

    /**
     * Cria a criptografia para o valor informado conforme a chave indicada.
     *
     * @param value
     * @param key
     * @return
     * @throws Exception
     */
    public static String getCripto(String value, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] message = value.getBytes();

        byte[] bkey = key.getBytes();

        //Encriptando
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(bkey, "AES"));
        byte[] encrypted = cipher.doFinal(message);

        return stringHexa(encrypted);

    }

    /**
     * Descriptografa o valor informado conforme a chave hexadecial indicada.
     *
     * @param value
     * @param hexKey
     * @return
     * @throws Exception
     */
    public static String getDescriptoHexa(String value, String hexKey) throws Exception {

        byte[] bkey = SecurityUtil.hexStringToByteArray(hexKey);
        String vkey = new String(bkey);

        return getDescripto(value, vkey);

    }

    /**
     * Descriptografa o valor informado conforme a chave indicada.
     *
     * @param value
     * @param key
     * @return
     * @throws Exception
     */
    public static String getDescripto(String value, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] bkey = key.getBytes();

        // Decriptando...
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(bkey, "AES"));

        byte[] encrypted = hexStringToByteArray(value);
        byte[] decrypted = cipher.doFinal(encrypted);

        return new String(decrypted);
    }

    private static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String stringHexa(byte[] bytes) {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    /**
     * Método utilizado para gerar um password com base no email do usuário
     * nos casos em que o usuário criar conta no Connecta 2.0 através de uma rede social
     * @param email
     * @return Base64 Hash do Password, null caso não consiga executar
     */
    public static String getConnectaPasswordBase64Hash(String email) {
        try {
            MessageDigest digest = MessageDigest.getInstance(SHA_256);
            byte[] hash = digest.digest(email.getBytes("UTF-8"));
            return encodeToBase64(hash);
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return null;
        } 
    }
    
    public static String encodeToBase64(byte[] imageByteArray) {
        return Base64.encodeBase64String(imageByteArray);
    }

}
