package com.songwz.probase.reflect;
import java.util.concurrent.*;

public class RefClass
{
	/**
	 * �����
	 */
	private static final  ConcurrentMap<String, ClassEntry> classContext = new ConcurrentHashMap<String, ClassEntry>(1000);	
			
	/**
	 * ��ȡClass����
	 * @param classPath Class����·��
	 * @return 
	 * @throws Exception
	 */
	public static Object getBean(String classPath) throws Exception
	{
		if (classPath == null ||classPath.trim().equals(""))
			return null;
		
		Object fBean = null;
		if (classContext.containsKey(classPath))
		{
			fBean = classContext.get(classPath).getBean();
		}else
		{
			ClassEntry classEntry = new ClassEntry(classPath);			
			classContext.put(classPath, classEntry);
			fBean = classEntry.getBean();
		}
		return fBean;
	}
	/**
	 * ��ȡClass�¶���
	 * @param classPath Class����·��
	 * @return 
	 * @throws Exception
	 */
	public static Object getNewBean(String classPath) throws Exception
	{
		if (classPath == null ||classPath.trim().equals(""))
			return null;
		
		Object fBean = null;
		
		if (classContext.containsKey(classPath))
		{
			fBean = classContext.get(classPath).getNewBean();
		}else
		{
			ClassEntry classEntry = new ClassEntry(classPath);			
			classContext.put(classPath, classEntry);
			fBean = classEntry.getBean();
		}
		return fBean;
	}
	/**
	 * ���Bean ����
	 * @param classPath
	 * @throws Exception
	 */
	public static void removeBean(String classPath) throws Exception
	{
		if (classPath == null ||classPath.trim().equals(""))
			return ;
		
		if (classContext.containsKey(classPath))
		{
			classContext.remove(classPath);
		}
	}
	/**
	 * ����ʱ�������
	 * @param lastTime ������ʱ�� ���Ϊ0 ��С��0 ��ȫ�����
	 */
	public  static void clear(long lastTime)
	{
		classContext.clear();
	} 
}
