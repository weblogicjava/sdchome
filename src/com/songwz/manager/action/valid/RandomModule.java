package com.songwz.manager.action.valid;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.songwz.manager.Manager;

/**
 * Created by Administrator on 14-1-19.
 */
@IocBean
@At("/"+Manager.APPNAME+"/random")
public class RandomModule {

    @At("/get")
    @Ok("void")
    public void get() throws IOException{
        OutputStream os=Mvcs.getResp().getOutputStream();
        RandomNumUtil random = RandomNumUtil.Instance() ;
        Mvcs.getHttpSession().setAttribute("randomcode",random.getString());
        ImageIO.write(random.getImage(), "JPEG", os) ;
    }

}
