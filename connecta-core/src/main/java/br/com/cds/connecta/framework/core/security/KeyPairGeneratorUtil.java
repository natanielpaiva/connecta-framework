package br.com.cds.connecta.framework.core.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import br.com.cds.connecta.framework.core.exception.SystemException;
import br.com.cds.connecta.framework.core.util.Util;

public class KeyPairGeneratorUtil {
	
	public static final String ALGORITHM = "RSA";
	
	private KeyPairGenerator keyGen = null;
	private KeyPair keyPair = null;
	
	public byte[] encrypt(String text) throws SystemException {
		byte[] cipherText = null;
		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, getKeyPair().getPrivate());
			
			cipherText = cipher.doFinal(text.getBytes());
		} catch (Exception e) {
			throw new SystemException(e);
		}
		return cipherText;
	}

	public String decrypt(byte[] text) throws SystemException {
		byte[] dectyptedText = null;
		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);

			cipher.init(Cipher.DECRYPT_MODE, getKeyPair().getPublic());
			dectyptedText = cipher.doFinal(text);
		} catch (Exception e) {
			throw new SystemException(e);
		}

		return new String(dectyptedText);
	}
	
	private static PublicKey createPublicKey(byte[] bytesKey) throws SystemException{
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesKey);
			return keyFactory.generatePublic(publicKeySpec);
		}catch(Exception e){
			throw new SystemException(e);
		}
	}
	
	public static String decrypt(byte[] text, byte[] bytesPublicKey) throws SystemException {
		byte[] dectyptedText = null;
		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, createPublicKey(bytesPublicKey));
			dectyptedText = cipher.doFinal(text);
		} catch (Exception e) {
			throw new SystemException(e);
		}

		return new String(dectyptedText);
	}

	public KeyPairGeneratorUtil() throws SystemException {
		try {
			keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e);
		}
	}
	
	public KeyPair getKeyPair(){
		if(Util.isNull(keyPair)){
			keyPair = keyGen.generateKeyPair(); 
		}
		return keyPair;
	}

}
