package com.songwz.probase.lang;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basic {

	/**
	 * 获取GUID标示
	 * 
	 * @return　返回GUID标示号码
	 */
	public static final String GUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 把某个字符串根据包含的特定字符串分成字符串树组
	 * 
	 * @param spliteStr
	 *            需要分割字符串
	 * @param subStr
	 *            　分割字符串标识
	 * @return
	 */
	public static String[] splite(String spliteStr, String subStr) {

		int count = subStr.length();

		int i = 100;

		String[] returnStr;

		Vector<String> StrVec = new Vector<String>();

		while (i > 0) {
			i = spliteStr.indexOf(subStr);

			if (i < 0)
				break;

			StrVec.add(spliteStr.substring(0, i));

			spliteStr = spliteStr.substring(i + count);
		}

		StrVec.add(spliteStr);

		returnStr = new String[StrVec.size()];

		for (int j = 0; j < StrVec.size(); j++)
			returnStr[j] = StrVec.get(j).toString();

		return returnStr;
	}

	/**
	 * 把字符串按照某种特种字符转换成数组
	 * 
	 * @param spliteStr
	 *            　需要分组字符串
	 * @param subStr
	 *            　特点字符串
	 * @return
	 */
	public static String[] commaToArray(String spliteStr, String subStr) {
		if (spliteStr == null)
			return new String[0];
		if (subStr == null)
			subStr = ",";

		if (!subStr.contains("\\"))
			subStr = "\\" + subStr;

		String splites[] = spliteStr.split(subStr, -2);
		return splites;
	}

	/**
	 * 默认","号分割
	 * 
	 * @param spliteStr
	 *            　需要分割字符串
	 * @return
	 */
	public static String[] commaToArray(String spliteStr) {
		return commaToArray(spliteStr, ",");
	}

	/**
	 * 替换某字符中的某些字符
	 * 
	 * @param BaseStr
	 *            原有字符
	 * @param oldStr
	 *            需要替换字符
	 * @param newStr
	 *            被替换字符
	 * @return 替换后字符
	 */
	public static String replace(String BaseStr, String oldStr, String newStr) {
		if (BaseStr == null)
			return null;
		if (oldStr == null || newStr == null)
			return BaseStr;

		StringBuffer stringbuffer = new StringBuffer();
		int i = 0;
		int j = BaseStr.indexOf(oldStr);
		int k = oldStr.length();
		for (; j >= 0; j = BaseStr.indexOf(oldStr, i)) {
			stringbuffer.append(BaseStr.substring(i, j));
			stringbuffer.append(newStr);
			i = j + k;
		}

		stringbuffer.append(BaseStr.substring(i));
		return stringbuffer.toString();
	}

	/**
	 * 删除字符串中的某段字符
	 * 
	 * @param s
	 *            原有字符
	 * @param s1
	 *            需要删除字符
	 * @return 删除后字符
	 */
	public static String delete(String s, String substr) {
		return replace(s, substr, "");
	}

	/**
	 * 字符类型转换成布尔类型
	 * 
	 * @param s
	 *            字符类型
	 * @return 布尔类型
	 */
	public static boolean IsTrue(String s) {
		if (s == null || s.trim().equals(""))
			return false;

		s = s.trim().toLowerCase();
		return s.equals("1") | s.equals("yes") | s.equals("true")
				| s.equals("on") | s.equals("y");
	}

	/**
	 * 字符类型转换成整数类型
	 * 
	 * @param s
	 *            字符类型
	 * @return 整数类型
	 * @throws Exception
	 */
	public static int getInt(String s) {
		if (s == null || s.trim().equals(""))
			return 0;
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException exception) {
			return 0;
		}
	}

	public static boolean validStrEqLength(String value, int length) {
		if (value == null) {
			return false;
		}
		if (value.getBytes().length != length) {
			return false;
		}
		return true;
	}

	/**
	 * 字符类型转换成浮点类型
	 * 
	 * @param s
	 *            字符类型
	 * @return 浮点类型
	 * @throws Exception
	 */
	public static double getDouble(String s) {
		if (s == null || s.trim().equals(""))
			return 0.0D;
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException exception) {
			return 0.0D;
		}
	}

	public static String getNoInLogStr(String s) {
		if (s == null || s.equals(""))
			return s;

		String s1 = "(or |= |'|and |delete |update |select |drop |all |backup |exec |truncate |create |OR |CREATE |DELETE |AND |UPDATE |SELECT |DROP |TRUNCATE |EXEC |Exec )";
		Pattern pattern = Pattern.compile(s1);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())
			throw new IllegalArgumentException("您提交的数据中含有非法的字符，请修改后重新提交！！！");
		else
			return s;
	}

	/**
	 * 分解字符串中参数值
	 * 
	 * @param strVar
	 * @return
	 * @throws YaconException
	 */
	public static String subStrVars(String strVar) throws Exception {
		StringBuffer sbuf = new StringBuffer();
		int i = 0;
		do {
			int j = strVar.indexOf(DELIM_START, i);

			if (j == -1) {
				if (i == 0) {
					return strVar;
				} else {
					sbuf.append(strVar.substring(i, strVar.length()));
					return sbuf.toString();
				}
			}

			sbuf.append(strVar.substring(i, j));

			int k = strVar.indexOf(DELIM_STOP, j);
			if (k == -1)
				throw new Exception(strVar + " 参数变量没有结束}，参数开始变量在 :" + j);

			j += DELIM_START_LEN;
			String key = strVar.substring(j, k);

			String replacement = System.getProperty(key);
			if (replacement != null) {
				String recursiveReplacement = subStrVars(replacement);
				sbuf.append(recursiveReplacement);
			} else
				throw new Exception(strVar + " 参数变量:" + key
						+ " ，从System.getProperty中获取的值为:NULL");

			i = k + DELIM_STOP_LEN;

		} while (true);

	}

	static String DELIM_START = "${";
	static char DELIM_STOP = '}';
	static int DELIM_START_LEN = 2;
	static int DELIM_STOP_LEN = 1;

}
