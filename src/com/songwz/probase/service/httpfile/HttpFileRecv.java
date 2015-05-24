package com.songwz.probase.service.httpfile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.songwz.probase.reflect.RefClass;

@SuppressWarnings("all")
public class HttpFileRecv extends HttpServlet {
	
	 public HttpFileRecv()
	 {
		 super();
	 }

	 @Override
	public void destroy() 
	 {
		 super.destroy();
	 }

	 @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
		 doPost(request, response);
	 }

	 /**
	  * 文件处理函数
	  */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException 
	 {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String contextPath = request.getContextPath();
		
		 /**
		  *  设置上传文件最大为 100M
		  */
		 final long MAX_SIZE     = 100 * 1024 * 1024;
		 
		 /**
		  *允许上传的文件格式的列表 
		  */
		  final String[] allowedExt = new String[] {"xml"};
		  
		  /**
		   *  实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
		   */
		  DiskFileItemFactory dfif = new DiskFileItemFactory();
		  /**
		   * 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
		   */
		  dfif.setSizeThreshold(4096);
		  
		  /**
		   * 用以上工厂实例化上传组件
		   */
		  ServletFileUpload sfu = new ServletFileUpload(dfif);
		  
		  /**
		   * 设置最大上传尺寸
		   */
		  sfu.setSizeMax(MAX_SIZE);
		  
		  /**
		   * 从request得到 所有 上传域的列表
		   */
		  List fileList = null;
		  
		  try 
		  {
			  fileList = sfu.parseRequest(request);
		  } catch (FileUploadException e)
		  {		/**处理文件尺寸过大异常*/
			   if (e instanceof SizeLimitExceededException) 
			   {
				   out.println("FAIL|文件尺寸超过规定大小:" + MAX_SIZE + "字节。");			
				   return;
			   }
			   e.printStackTrace();
		  }
		  /** 没有文件上传*/
		  if (fileList == null || fileList.size() == 0) 
		  {
			  out.println("FAIL|未选择上传文件");
			  return;
		  }
		  
		  Hashtable<String, String> params = new Hashtable<String, String>() ;
		  /** 得到自定义的文件路径*/
		  Iterator formIterator = fileList.iterator();
		  String FILE_PATH = "" ;
		  String businessClass = "" ;
		  while (formIterator.hasNext()) {
			  FileItem fileItem = (FileItem) formIterator.next();
			  params.put(fileItem.getFieldName(), fileItem.getString());
			  if("TARGET_FILEPATH".equals(fileItem.getFieldName())){
				  FILE_PATH = fileItem.getString() ;
			  }
			  if("HTTP_FILE_BUSINESS".equals(fileItem.getFieldName())){
				  businessClass = fileItem.getString() ;
			  }
		  }
		  /**
		   * 设置存放临时文件的目录,web根目录下的seekupload目录下 
		   */
		  if(FILE_PATH==null || "".equals(FILE_PATH)){
			  out.println("FAIL|缺少服务端路径配置!");
			  return ;
		  }
		  try{
		  File filedir = new File(FILE_PATH) ; 
		  if(!filedir.exists()){
			  filedir.mkdirs() ;
			  dfif.setRepository(filedir);
		  }
		  }catch(Exception e){
			  e.printStackTrace();
			  out.print("FAIL|文件上传失败！"+e.getMessage()) ;
			  return ;
		  }
		  
		  /** 得到所有上传的文件*/
		  Iterator fileItr = fileList.iterator();
		  /** 循环处理所有文件*/
		  while (fileItr.hasNext()) 
		  {
			  FileItem fileItem = null;
			  String path = null;
			  long size = 0;
			  /** 得到当前文件*/
			  fileItem = (FileItem) fileItr.next();
			  /** 忽略简单form字段而不是上传域的文件域(<input type="text" />等)*/
			  if (fileItem == null ||fileItem.isFormField()) {
				  fileItem.getString() ;
				  continue;
			  }
			 
			  /** 得到文件的完整文件名*/
			  path = fileItem.getName();
			  path = URLDecoder.decode(path, "UTF-8") ;
			  System.out.println("*****************************************LOG*****************************************");
			  System.out.println(path);
			  System.out.println("*****************************************LOG*****************************************");
			  
			  /** 得到文件的大小*/
			  size = fileItem.getSize();
			  if ("".equals(path) || size == 0) {
				  out.println("FAIL|上传文件的大小为0，上传失败");
				  return;
			  }
	
			   /** 得到去除路径的文件名*/
			   String t_name = path.substring(path.lastIndexOf("\\") + 1);
			   /** 得到文件的扩展名(无扩展名时将得到全名)*/
			   String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
			   
			   /** 拒绝接受规定文件格式之外的文件类型*/
			   /*上传文件类型不受限制*/
			   
			   /** 保存的最终文件完整路径,保存在web根目录下的ImagesUploaded目录下*/
			   /*保持上传文件和上传后的文件名称保持一致*/
			   String u_name = FILE_PATH +"/"+ t_name;
			   
			   try {
				    /** 保存文件*/
				    fileItem.write(new File(u_name));
				    
				    if(businessClass!=null && !"".equals(businessClass)){
				    	IHttpFileBusiness business = (IHttpFileBusiness) RefClass.getBean(businessClass);
				    	String busiRet = business.invoke(params,u_name) ;
				    	if(!busiRet.startsWith(IHttpFileBusiness.SUCCESS)){
				    		fileItem.delete() ;
				    		out.println("FAIL|文件上传后置业务处理失败！服务端文件已删除<br/>失败信息："+busiRet);
				    		return ;
				    	}
				    }
				    
				    out.println("SUCCESS|文件上传成功. 已保存为: " + t_name + "；文件大小: " + size + "字节");
				    //out.println("<a href=\"upload.html\" target=\"_top\">继续上传</a>");
			  } catch (Exception e) {
				   e.printStackTrace();
				   out.println("FAIL|上传文件错误:"+e.getMessage());
			   }
		 }
	 }

	 @Override
	public void init() throws ServletException {
		 
	 }
	
	 
}

    
