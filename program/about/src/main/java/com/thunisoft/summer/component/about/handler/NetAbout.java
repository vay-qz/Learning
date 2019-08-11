package com.thunisoft.summer.component.about.handler;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.AboutSet;
import com.thunisoft.summer.component.about.AboutType;

/**
 * 关于网络信息
 * HardWareAbout
 * @author guof
 * @version 1.0
 *
 */
public class NetAbout extends AbstractAbout {
    /**
     * 添加关于信息
     * @param actx 关于上下文
     */
    protected void append(AboutContext actx) {
        AboutSet as = new AboutSet();
        as.setName("网络接口信息");
        as.setType(AboutType.NET_ABOUT.toString());

        as.add("属性名称");
        as.add("属性值");
        
        Enumeration<NetworkInterface> netInterfaces = null;   
        try {   
            netInterfaces = NetworkInterface.getNetworkInterfaces();   
            while (netInterfaces.hasMoreElements()) {   
                NetworkInterface ni = netInterfaces.nextElement();                                
                Enumeration<InetAddress> ips = ni.getInetAddresses();   
                while (ips.hasMoreElements()) {
                    String msg="接口[%s][%s]";
                    msg=String.format(msg, ni.getDisplayName(),ni.getName());
                    InetAddress  inet=ips.nextElement();
                    if(inet instanceof Inet4Address){
                        msg=msg+"IPV4";
                    }else if(inet instanceof Inet6Address){
                        msg=msg+"IPV6";
                    }else{
                        msg=msg+"UNKOWN";
                    }
                    String ip=inet.getHostAddress();                   
                    this.setStatus(as, msg,ip );
                }   
            }   
        } catch (Exception e) {   
            this.setStatus(as,"获取异常", e.getMessage());   
        }  
        actx.put(as);
    }
}
