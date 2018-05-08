package com.lk.play.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;




/**
 * md5ɢ����
 * @author Administrator
 *
 */
public class Digests {
	private static final String SHA1 = "SHA-1";
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * �������ַ�������sha1ɢ��.
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
	 * ���ַ�������ɢ��, sha-1
	 * @param input ɢ���ֽ�
	 * @param algorithm ɢ������
	 * @param salt  ��
	 * @param iterations ɢ�д���
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
	 * ���������Byte[]��Ϊsalt.
	 * 
	 * @param numBytes byte����Ĵ�С
	 */
	public static byte[] generateSalt(int numBytes) {		

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

}
