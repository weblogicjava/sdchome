package com.songwz.sdchome.action.bbs;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.service.EntityService;

import com.songwz.probase.lang.BusinessDate;
import com.songwz.probase.resp.SwapArea;
import com.songwz.sdchome.SDC;
import com.songwz.sdchome.beans.SubjectBase;
import com.songwz.sdchome.beans.UserInfo;

@At("/" + SDC.APPNAME + "/SubjectBase")
@IocBean(fields = { "dao" })
public class SubjectBaseModule extends EntityService<SubjectBase> {

	private static final Log log = Logs.get();

	@At
	public Object list(@Param("page") int page, @Param("rows") int rows) {
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<SubjectBase> list = dao().query(SubjectBase.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(SubjectBase.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}

	@At
	@Filters(@By(type = CheckSession.class, args = { SDC.SESSION_USER , "/SDCHOME/login.jsp" }))
	public SwapArea add(@Param("..") SubjectBase base) {
		try {
			UserInfo userInfo = (UserInfo) Mvcs.getHttpSession().getAttribute(SDC.SESSION_USER);
			base.setAuthorid(userInfo.getUid());
			base.setSubjectid(BusinessDate.getSerialNumFromDate());
			base.setClickcount(0);
			base.setLastMdate(new Date());
			base.setLevel("1");
			base.setLovecount(0);
			base.setRecommcount(0);
			base.setState("0");
			base.setWriteDate(new Date());
			dao().insert(base);
			return SwapArea.createSwapArea().setSuccessCode();
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return SwapArea.createSwapArea().setFailCode().setErrorMsg(e.getMessage());
		}
	}

	@At
	public boolean delete(@Param("..") SubjectBase obj) {
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
	@Ok("jsp:/SDCHOME/bbs/SubjectEdit.jsp")
	public void get2edit(@Param("subjectid") String subjectid) {
		try {
			SubjectBase base = dao().fetch(SubjectBase.class, subjectid);
			Mvcs.getReq().setAttribute("subject", base);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
		}
	}

	@At
	public boolean update(@Param("..") SubjectBase obj) {
		try {
			dao().updateIgnoreNull(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}

	@At
	public SubjectBase select(@Param("subjectid") String subjectid) {
		try {
			return dao().fetch(SubjectBase.class, subjectid);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return new SubjectBase();
		}
	}

}