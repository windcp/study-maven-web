package com.lk.play.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;




/**
 * md5散列类
 * @author Administrator
 *
 */
public class Digests {
	private static final String SHA1 = "SHA-1";
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 对输入字符串进行sha1散列.
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}

	
	/**
	 * 对字符串进行散列, sha-1
	 * @param input 散列字节
	 * @param algorithm 散列类型
	 * @param salt  盐
	 * @param iterations 散列次数
	 * @return
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {

			byte[] result = null;
			try {
				MessageDigest digest = MessageDigest.getInstance(algorithm);

				if (salt != null) {
					digest.update(salt);
				}

				result = digest.digest(input);

				for (int i = 1; i < iterations; i++) {
					digest.reset();
					result = digest.digest(result);
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;	
	}
	
	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {		

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

}
