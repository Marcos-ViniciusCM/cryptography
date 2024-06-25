package br.com.marcos.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoService {
	
	
	private static StrongTextEncryptor encryptor; 

	
	static {
		encryptor = new StrongTextEncryptor();
		encryptor.setPassword("Helo123");
	}
	
		public static String encryptText(String text) {
			return encryptor.encrypt(text);
			
			
			
		}
		
		public static String decrypt(String encrypt) {
			
			return encryptor.decrypt(encrypt);
			
		}
}
