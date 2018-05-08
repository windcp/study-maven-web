package com.lk.play.common.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.util.ByteSource;
/**
 * Éú³ÉËæ»úÑÎ
 * @author Administrator
 *
 */
public class SaltUtil {

	public static String getSalt() {
		SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();		
		String salt = randomNumberGenerator.nextBytes().toHex().substring(0, 16);
		ByteSource bytes = ByteSource.Util.bytes(salt);
		return salt;
	}
}
