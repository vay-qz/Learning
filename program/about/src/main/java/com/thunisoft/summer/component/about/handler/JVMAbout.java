package com.thunisoft.summer.component.about.handler;

import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;
import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.AboutSet;
import com.thunisoft.summer.component.about.AboutType;

/**
 * 关于jvm
 * JVMAbout
 * @author guof
 * @version 1.0
 *
 */
@SuppressWarnings("restriction")
public class JVMAbout extends AbstractAbout {
    
    /**
     * 添加关于信息
     * @param actx 关于上下文
     */
    protected void append(AboutContext actx) {
        AboutSet as = new AboutSet();
        as.setName("JAVA虚拟机信息");
        as.setType(AboutType.JVM_ABOUT.toString());        
        as.add("属性名称");
        as.add("属性值");
        actx.put(as);
        
        RuntimeMXBean rmb=(RuntimeMXBean)ManagementFactory.getRuntimeMXBean();         
        this.setStatus(as,"JVM描述",rmb.getVmVendor()+" "+rmb.getVmName()+" "+rmb.getVmVersion());  
        this.setStatus(as,"JVM当前字符集",Charset.defaultCharset().toString());
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long st=rmb.getStartTime();
        Date sd=new Date(st);
        String startTime=format.format(sd);
        long rt=((System.currentTimeMillis()-st)/1000)/60;
        startTime=startTime+"  已运行时间:"+rt+"分钟";
        startTime=startTime+"("+rt/60+"小时)(" +(rt/60)/24+"天)";
        this.setStatus(as,"JVM启动时间",startTime);
        
        List<String> lst=rmb.getInputArguments();
        StringBuffer params=new StringBuffer();
        for(String s:lst){
            params.append(s);
            params.append("</br>");
        }
        
        this.setStatus(as,"JVM参数",params.toString());
        
        long totalMemory = Runtime.getRuntime().totalMemory()/1024;
        this.setStatus(as,"JVM内存总量",totalMemory+"KB("+totalMemory/1024+")MB"); 
        
        long freeMemory = Runtime.getRuntime().freeMemory()/1024;
        this.setStatus(as,"JVM空闲内存",freeMemory+"KB("+freeMemory/1024+")MB"); 
        
        long maxMemory=Runtime.getRuntime().maxMemory()/1024;
        this.setStatus(as,"JVM最大内存",maxMemory+"KB("+maxMemory/1024+")MB"); 
        
        long freeAndTotalMemory=(long)(((1.0*freeMemory)/totalMemory)*100);
        this.setStatus(as,"JVM空闲内存百分比",freeAndTotalMemory+"%"); 

        
        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况         
        ThreadMXBean tm=(ThreadMXBean)ManagementFactory.getThreadMXBean(); 
        this.setStatus(as,"当前线程数",tm.getThreadCount());
        this.setStatus(as,"线程数峰值",tm.getPeakThreadCount());
        this.setStatus(as,"守护线程数",tm.getDaemonThreadCount());
        
        OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();        
        this.setStatus(as,"操作系统名字",osm.getName());
        this.setStatus(as,"操作系统版本",osm.getVersion());
        this.setStatus(as,"操作系统架构",osm.getArch()); 
        this.setStatus(as,"处理器核心数",osm.getAvailableProcessors());      
        
        long cVirtualMemorySize= osm.getCommittedVirtualMemorySize()/1024;
        this.setStatus(as,"已提交的虚拟内存",cVirtualMemorySize+"KB("+cVirtualMemorySize/1024+")MB"); 
        
        long freeSwapSpaceSize=osm.getFreeSwapSpaceSize()/1024;
        this.setStatus(as,"系统空闲交换内存",freeSwapSpaceSize+"KB("+freeSwapSpaceSize/1024+")MB");
        
        long freePhysicalMemorySize=osm.getFreePhysicalMemorySize()/1024;
        this.setStatus(as,"系统空闲的物理内存",freePhysicalMemorySize+"KB("+freePhysicalMemorySize/1024+")MB");
        
        long totalPhysicalMemorySize=osm.getTotalPhysicalMemorySize()/1024;
        this.setStatus(as,"系统总物理内存",totalPhysicalMemorySize+"KB("+totalPhysicalMemorySize/1024+")MB");
        
        long freeAndTotalPhysicalMemory=(long)((freePhysicalMemorySize*1.0/totalPhysicalMemorySize)*100);       
        this.setStatus(as,"系统空闲内存百分比",freeAndTotalPhysicalMemory+"%");
        
        AboutSet proAs = new AboutSet();
        proAs.setName("JAVA属性信息");
        proAs.setType(AboutType.JVM_PRO_ABOUT.toString());        
        proAs.add("属性名称");
        proAs.add("属性值");
        actx.put(proAs);
        
        Map<String, String> map=rmb.getSystemProperties();
        Set<Entry<String,String>> sets= map.entrySet();
        for(Entry<String,String> en:sets){
            this.setStatus(proAs,en.getKey(),en.getValue());
        }
    }
    

}
