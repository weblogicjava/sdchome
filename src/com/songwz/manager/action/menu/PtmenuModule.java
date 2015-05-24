package com.songwz.manager.action.menu;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

import com.songwz.manager.Manager;
import com.songwz.manager.beans.Ptmenu;
import com.songwz.probase.bean.WrapIntegerBean;

@At("/"+Manager.APPNAME+"/ptmenu")
@IocBean(fields={"dao"})
public class PtmenuModule extends EntityService<Ptmenu>{

    private static final Log log = Logs.get();
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		System.out.println("**********************************************************");
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<Ptmenu> list = dao().query(Ptmenu.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Ptmenu.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("..") Ptmenu obj){
		try{
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public Ptmenu addType(@Param("..") Ptmenu obj){
		try{
			
			Sql sql = Sqls.create("SELECT MAX(MENUID) AS NUM FROM PTMENU WHERE PARENTMENUID=@PMID");
			sql.params().set("PMID", obj.getParentmenuid());
			sql.setCallback(Sqls.callback.entities());
			sql.setEntity(dao().getEntity(WrapIntegerBean.class));
			dao().execute(sql);
			List<WrapIntegerBean> list = sql.getList(WrapIntegerBean.class);
			
			DecimalFormat df = new DecimalFormat("000") ;
			String menuid = obj.getParentmenuid()+df.format(list.get(0).getNum()+1) ;
			obj.setMenuid(menuid);
			dao().insert(obj);
			return obj;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return null ;
		}
	}
	
	@At
	public boolean delete(@Param("..") Ptmenu obj) {
		try {
			dao().delete(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}
	
	@At
	public boolean update(@Param("..") Ptmenu obj) {
		try {
			dao().update(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}
}