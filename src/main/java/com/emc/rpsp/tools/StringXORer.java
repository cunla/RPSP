package com.emc.rpsp.tools;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

public class StringXORer {

	public static String encode(String s, String key) {
		return base64Encode(xorWithKey(s.getBytes(), key.getBytes()));
	}

	public static String decode(String s, String key) {
		return new String(xorWithKey(base64Decode(s), key.getBytes()));
	}

	private static byte[] xorWithKey(byte[] a, byte[] key) {
		byte[] out = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = (byte) (a[i] ^ key[i % key.length]);
		}
		return out;
	}

	public static String encrypt(String key1, String key2, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));

			SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
			        "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string:"
			        + Base64.encodeBase64String(encrypted));
			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String key1, String key2, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));

			SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
			        "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static byte[] base64Decode(String s) {
		try {
			BASE64Decoder d = new BASE64Decoder();
			return d.decodeBuffer(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String base64Encode(byte[] bytes) {
		BASE64Encoder enc = new BASE64Encoder();
		return enc.encode(bytes).replaceAll("\\s", "");
	}
}