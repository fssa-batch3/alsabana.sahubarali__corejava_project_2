package com.fssa.healthyhair.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtil {
	
	   public static String getSecurePassword(String password, byte[] salt) {

	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(salt);
	            byte[] bytes = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }

	    public static byte[] getSalt() throws NoSuchAlgorithmException {
	        SecureRandom random = new SecureRandom();
	        byte[] salt = new byte[16];
	        random.nextBytes(salt);
	        return salt;
	    }
	    
	    
	    public static String byteArrayToHexString(byte[] byteArray) {
		    StringBuilder hexString = new StringBuilder(2 * byteArray.length);
		    for (byte b : byteArray) {
		        String hex = Integer.toHexString(0xFF & b);
		        if (hex.length() == 1) {
		            hexString.append('0'); // Pad single-digit hex values with a leading zero
		        }
		        hexString.append(hex);
		    }
		    return hexString.toString();
		}
		
		public static byte[] hexStringToByteArray(String hexString) {
		    int len = hexString.length();
		    byte[] byteArray = new byte[len / 2];
		    for (int i = 0; i < len; i += 2) {
		        byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
		                             + Character.digit(hexString.charAt(i + 1), 16));
		    }
		    return byteArray;
		}

}
