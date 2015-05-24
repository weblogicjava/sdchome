package com.songwz.probase.respro;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.songwz.probase.lang.LocalMessage;

public class PropertiesRes {

	private static Properties properties ;
	
	public static void forceReload(boolean isForce) {
		if (properties == null || isForce) {
			properties = new Properties();
			InputStream in = null;
			try {
				in = PropertiesRes.class.getResourceAsStream("Applicaiton.properties");
				properties.load(in);
			} catch (IOException ioe) {
				ioe.printStackTrace() ;
			} finally {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace() ; 
				}
			}

		}
	}
	
	public static void load(){
		forceReload(false);
	}
	
	public static String getPropertiesResValue(String key) {
		if(properties==null){
			load();
		}
		return properties.getProperty(key) ;
	}
	
	public static void main(String[] args) throws Exception{
		
		System.out.println(LocalMessage.getAppPath());
		
		System.out.println(PropertiesRes.class.getClassLoader().getResource("Applicaiton.properties").getPath());
		
	}
	
}
