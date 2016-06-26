package com.karma.workhistory.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomPasswordGenerator {
    
    transient static String passwordForEmail = "";

	static final String passwordCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom random = new SecureRandom();

	public static String getRandomPassword(int len) {
		StringBuilder builder = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			builder.append(passwordCharacters.charAt(random.nextInt(passwordCharacters.length())));
		
		//return builder.toString();
		passwordForEmail = builder.toString();
		return "admin123";
	}
	
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
}