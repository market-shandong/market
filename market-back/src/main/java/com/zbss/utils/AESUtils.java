package com.zbss.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

	// 加密
	public static String encode(String key, String s) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		byte[] iv = new byte[16];
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(),"AES"), ivSpec);

		return Base64Utils.encode(cipher.doFinal(s.getBytes("UTF-8")));
	}
	
	// 解密
	public static String decode(String key, String s) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		byte[] iv = new byte[16];
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(),"AES"), ivSpec);
		
		return new String( cipher.doFinal(Base64Utils.decode(s)), "UTF-8");
	}

	public static void main(String[] args) throws Exception {
		String m = AESUtils.encode("N6AG2WHLH74S5WC5", "123");
		System.out.println(m);
		String b = AESUtils.decode("N6AG2WHLH74S5WC5", m);
		System.out.println(b);
	}
}
