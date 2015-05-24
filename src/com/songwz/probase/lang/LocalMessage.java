package com.songwz.probase.lang;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class LocalMessage {

	private static String localAppPath = null;

	/**
	 * 获取系统工程路径
	 * 
	 * @return
	 */
	protected String getProAppPath() throws Exception {

		if (this.getClass().getClassLoader().getResource("/") != null)
			localAppPath = this.getClass().getClassLoader().getResource("/")
					.getPath();
		else if (this.getClass().getResource("/") != null)
			localAppPath = this.getClass().getResource("/").getPath();

		if (localAppPath == null)
			throw new Exception("获取系统路径为NULL");

		try {
			localAppPath = java.net.URLDecoder.decode(localAppPath, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (localAppPath.indexOf(":/") > -1)
			localAppPath = localAppPath.substring(1);

		localAppPath = localAppPath.replace("WEB-INF/classes/", "");

		return localAppPath;
	}

	/**
	 * 获取当前系统绝对路径
	 * 
	 * @return
	 * @throws YaconException
	 */
	public static String getAppPath() throws Exception {
		if (localAppPath == null) {
			LocalMessage localMessage = new LocalMessage();
			return localMessage.getProAppPath();
		} else
			return localAppPath;
	}

	/**
	 * 获取当前系统绝对路径
	 * 
	 * @return
	 * @throws YaconException
	 */
	public static List<String> getLocalIP() throws Exception {
		List<String> ipList = Collections
				.synchronizedList(new ArrayList<String>());
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface
				.getNetworkInterfaces();
		while (netInterfaces.hasMoreElements()) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> ips = ni.getInetAddresses();
			while (ips.hasMoreElements()) {
				String ip = ips.nextElement().getHostAddress();
				if (VerifyData.isIP(ip)) {
					ipList.add(ip);
				}
			}
		}
		return ipList;
	}

}
