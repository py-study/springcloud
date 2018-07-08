package com.oe.edu;

public class OEEncode {

	private static final int Num = 10;
	private static final int Index_1 = 10;
	private static final int Index_2 = 30;
	private static final String KeyString = "abcdefghijklmnopqrstuvwxyz"
											+ "0123456789"
											+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
											+ ".$/";
	
	private static String getRandomString(int length) {
	    StringBuffer sb = new StringBuffer();
	    int len = KeyString.length();
	    for (int i = 0; i < length; i++) {
	       sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
	    }
	    return sb.toString();
	}
	

	public static String getOEEncodedPassword(String encodedPassword) {
		return encodedPassword.substring(0, Index_1 + 1) 
				+ getRandomString(Num) 
				+ encodedPassword.substring(Index_1 + 1, Index_2 + 1)
				+ getRandomString(Num)
				+ encodedPassword.substring(Index_2 + 1, encodedPassword.length());
	}
	
	public static String removeOEEncodedPassword(String encodedPassword) {
		return encodedPassword.replace(encodedPassword.substring(Index_2 + Num + 1, Index_2 + Num + Num + 1), "")
				.replace(encodedPassword.substring(Index_1 + 1, Index_1 + Num + 1), "");
	}
	
}
