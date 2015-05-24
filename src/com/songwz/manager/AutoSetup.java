package com.songwz.manager;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class AutoSetup implements Setup {

    private static final Log log = Logs.get() ;

    @Override
    public void destroy(NutConfig config) {
        log.debug(""+config.getIoc());
    }

    @Override
    public void init(NutConfig config) {
        log.debug("config.getIoc = "+config.getIoc());
        Dao dao = config.getIoc().get(Dao.class) ;
        for(Class<?> kClass : Scans.me().scanPackage("com.songwz.manager.beans")){
            if(null != kClass.getAnnotation(Table.class)){
                dao.create(kClass, false);
            }
        }
        
    }

}

