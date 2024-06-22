package br.com.marcos.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CryptoService {

	
		public static String encryptText(String text) {
			byte[] encodedBytes = Base64.encodeBase64(text.getBytes());
	        return new String(encodedBytes);
			
		}
		
		public static String decrypt(String encrypt) {
			byte[] decodedByte = Base64.decodeBase64( encrypt);
			return new String(decodedByte);
			
		}
}
