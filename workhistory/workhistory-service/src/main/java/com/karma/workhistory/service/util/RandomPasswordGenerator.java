package com.karma.workhistory.service.util;

import java.security.SecureRandom;

public class RandomPasswordGenerator {

	static final String passwordCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom random = new SecureRandom();
	
	String getRandomPassword( int len ){
		   StringBuilder builder = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
			   builder.append( passwordCharacters.charAt( random.nextInt(passwordCharacters.length()) ) );
		   return builder.toString();
		}
}