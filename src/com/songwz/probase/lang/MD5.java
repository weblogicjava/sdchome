package com.songwz.probase.lang;

import java.security.MessageDigest;

/**
 * 
 * Ϊ��ά���û������밲ȫ����Ҫʹ���������<br/>
 * �û����붪ʧֻ��ͨ��������벻�ܻ��ԭ��������<br/>
 * ά���û�����Ϣ��ȫ<br/>
 * @author lenovo
 *
 */
public class MD5 {
	private static MessageDigest md5;

	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * Computes the MD5 fingerprint of a string.
	 * 
	 * @return the MD5 digest of the input <code>String</code>
	 */
	public static String encode(String target) {
		// convert input String to a char[]
		// convert that char[] to byte[]
		// get the md5 digest as byte[]
		// bit-wise AND that byte[] with 0xff
		// prepend "0" to the output StringBuffer to make sure that we don't end
		// up with
		// something like "e21ff" instead of "e201ff"

		char[] charArray = target.toCharArray();

		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}
	
}
