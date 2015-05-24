package com.songwz.probase.lang;

public class DeCode {

	public DeCode() {
	}

	// 字符串的加码方法：把字符串按照某种格式转换成十六进制的字符串
	public static String encode(String b) {
		if (b == null) {
			return b;
		}
		String s = "";
		String temp = "";
		String flag = "_";

		int asciiNum = 0;
		int n = 0;
		if ((b == null) || (b.equals("")))
			return "";

		char[] by = b.toCharArray();
		while (n < by.length) {
			asciiNum = by[n];
			temp = java.lang.Long.toHexString(asciiNum);
			if (asciiNum > 255 || (asciiNum < 0)) {

				temp = fillLeftWithZero(temp, 4);
				if (flag.equals("_")) {
					flag = "^";
					s += "[^" + temp;
				} else if (flag.equals("~")) {
					flag = "^";
					s += "^" + temp;
				} else if (flag.equals("^")) {
					s += temp;
				}
			} else if ((asciiNum < 48) || (asciiNum > 57 && asciiNum < 65)
					|| (asciiNum > 90 && asciiNum < 97) || (asciiNum > 122)) {
				temp = fillLeftWithZero(temp, 2);
				if (flag.equals("_")) {
					flag = "~";
					s += "[~" + temp;
				} else if (flag.equals("~")) {
					s += temp;
				} else if (flag.equals("^")) {
					flag = "~";
					s += "~" + temp;
				}
			} else {
				if ((flag.equals("^")) || (flag.equals("~"))) {
					flag = "_";
					s += "]" + (char) asciiNum;
				} else {
					s += (char) asciiNum;
				}
			}
			n++;
		}
		return s;
	}

	// 把某种格式的十六进制的字符串转换成普通的字符串
	public static String decode(String Str) {
		try {
			String temp = "";
			String OutStr = "";
			String flag = "_";
			int asciiNum = 0;

			if ((Str == null) || (Str.equals("")))
				return "";

			for (int i = 0; i < Str.length(); i++) {
				temp = Str.substring(i, i + 1);

				if (temp.equals("[")) {
					i++;
					temp = Str.substring(i, i + 1);
				}
				if (temp.equals("]")) {
					flag = "_";
					continue;
				}
				if (temp.equals("~")) {
					flag = "~";
					i++;
				}
				if (temp.equals("^")) {
					flag = "^";
					i++;
				}

				if (flag.equals("~")) {
					temp = Str.substring(i, i + 2);
					asciiNum = java.lang.Integer.parseInt(temp, 16);
					OutStr += String.valueOf((char) asciiNum);
					i++;
				}

				if (flag.equals("^")) {
					temp = Str.substring(i, i + 4);
					if (temp.toUpperCase().equals("FFFF")) {
						i += 4;
						temp = Str.substring(i, i + 4);
					}
					asciiNum = java.lang.Integer.parseInt(temp, 16);
					OutStr += String.valueOf((char) asciiNum);
					i += 3;

				}
				if (flag.equals("_")) {
					OutStr += temp;

				}

			}

			return OutStr;
		} catch (Exception e) {

			return e.getMessage();
		}
	}

	// /字符串从左边补0
	private static String fillLeftWithZero(String inStr, int len) {
		int count = inStr.length();
		String outStr = inStr;
		while (count < len) {
			outStr = "0" + outStr;
			count = outStr.length();
		}
		return outStr;
	}

	// 从全角专向半角
	public static String ABCToDBC(String changeStr) {
		char[] by = changeStr.toCharArray();
		int charNum = 0;

		String retStr = "";

		for (int i = 0; i < by.length; i++) {
			charNum = by[i];

			if (charNum > 65280 && charNum < 65375) {
				charNum = charNum - 65248;
			}
			if (charNum == 183)
				charNum = 46;

			retStr += String.valueOf((char) charNum);
		}

		return retStr;
	}

	// html格式转换
	public static String htmEncode(String s) {
		StringBuffer stringbuffer = new StringBuffer();
		int j = s.length();
		for (int i = 0; i < j; i++) {
			char c = s.charAt(i);
			switch (c) {
			case 60: // '<'
				stringbuffer.append("&lt;");
				break;

			case 62: // '>'
				stringbuffer.append("&gt;");
				break;

			case 38: // '&'
				stringbuffer.append("&amp;");
				break;

			case 34: // '"'
				stringbuffer.append("&quot;");
				break;

			case 169:
				stringbuffer.append("&copy;");
				break;

			case 174:
				stringbuffer.append("&reg;");
				break;

			case 165:
				stringbuffer.append("&yen;");
				break;

			case 8364:
				stringbuffer.append("&euro;");
				break;

			case 8482:
				stringbuffer.append("&#153;");
				break;

			case 13: // '\r'
				if (i < j - 1 && s.charAt(i + 1) == '\n') {
					stringbuffer.append("<br>");
					i++;
				}
				break;

			case 32: // ' '
				if (i < j - 1 && s.charAt(i + 1) == ' ') {
					stringbuffer.append(" &nbsp;");
					i++;
					break;
				}
				// fall through

			default:
				stringbuffer.append(c);
				break;
			}
		}

		return new String(stringbuffer.toString());
	}

	/**
	 * 字符编码转换
	 * 
	 * @param content
	 *            需要转换的内容
	 * @param fromCoding
	 *            转换前字符集
	 * @param toCoding
	 *            转换后字符集
	 * @return
	 */
	public static String dbCharCoding(String content, String fromCoding,
			String toCoding) {
		if (content == null)
			return null;

		if (fromCoding != null
				&& toCoding != null
				&& fromCoding.trim().toLowerCase()
						.equals(toCoding.trim().toLowerCase()))
			return content;
		try {
			byte[] contentByte;
			if (fromCoding == null || fromCoding.trim().equals(""))
				contentByte = content.getBytes();
			else
				contentByte = content.getBytes(fromCoding);

			if (toCoding == null || toCoding.trim().equals(""))
				return new String(contentByte);
			else
				return new String(contentByte, toCoding);

		} catch (Exception e) {
			return content;
		}
	}

}
