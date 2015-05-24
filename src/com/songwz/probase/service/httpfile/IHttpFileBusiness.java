package com.songwz.probase.service.httpfile;

import java.util.Hashtable;

public interface IHttpFileBusiness {

	public final static String SUCCESS = "success:" ;
	
	public final static String FAIL = "fail:" ;
	
	public String invoke(Hashtable<String, String> params,String filepath) ;
	
}
