package com.songwz.probase.reflect;

import java.io.Serializable;

@SuppressWarnings("all")
public class ClassEntry implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 实体对象
	 */
	private Class fClass = null;

	private Object fBean = null;

	/**
	 * 实体对象键值
	 */
	private String fKey;

	/**
	 * 创建时间
	 */
	private long created = -1;

	/**
	 * 实体对象构造函数
	 * 
	 * @param key
	 *            实体键值
	 * @param content
	 *            实体主体
	 * @throws Exception
	 */
	public ClassEntry(String classPath) throws Exception {
		fKey = classPath;
		fClass = Class.forName(classPath);
		fBean = fClass.newInstance();
		created = System.currentTimeMillis();
	}

	/**
	 * 获取键值
	 * 
	 * @return 返回键值
	 */
	public String getKey() {
		return fKey;
	}

	/**
	 * 获取主体
	 * 
	 * @return 返回主体
	 */
	@SuppressWarnings("unchecked")
	public Class getClassObj() {
		return fClass;
	}

	/**
	 * 获取已实例化对象
	 * 
	 * @return
	 */
	public Object getBean() {
		return fBean;
	}

	/**
	 * 获取新实例化对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object getNewBean() throws Exception {
		return fClass.newInstance();
	}

	/**
	 * 返回创建时间
	 * 
	 * @return
	 */
	public long getCreateTime() {
		return created;
	}

}
