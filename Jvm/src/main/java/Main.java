import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class OOMObject{

    }

    private static int stackLength = 0;

    public static void main(String[] args) throws Throwable {
        Main main = new Main();
//        main.heapOOM();
//        try{
//            main.stackOF();
//        }catch (Throwable e){
//            System.out.println(stackLength);
//            throw e;
//        }
//        main.stackOOM();
//        main.metaSpaceOOM(); //未完成
//        main.directMemoryOOM();
        main.testAllocation();
    }

    /**
     * 测试分代分配
     * 参数：
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseSerialGC
     * -XX:PretenureSizeThreshold=5242880
     */
    private void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5;

        allocation1 = new byte[4 * 1024*1024];
        //eden区有8M，只用了4M为什么就要进行minor gc
        allocation3 = new byte[2 * 1024*1024];


//        allocation3 = new byte[3*512*1024];
//        //为什么接近极限时会产生full gc
//        allocation4 = new byte[512*1024];
    }

    /**
     * 直接内存溢出
     * 参数：
     * -XX:MaxDirectMemorySize=10M
     * -Xmx20M
     */
    private void directMemoryOOM() throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(1024*1024);
        }
    }

    /**
     * 元数据区溢出
     * 参数：
     * -XX:MetaspaceSize=8m
     * -XX:MaxMetaspaceSize=50m
     */
    private void metaSpaceOOM() {
    }

    /**
     * 栈溢出OOM
     * JVM参数：
     * -Xss2m
     * ！！！Windowns系统下会卡死
     */
    private void stackOOM() {
        while(true){
            new Thread(()->{
                while(true){

                }
            }).start();
        }
    }

    /**
     * 栈溢出SOF
     * 参数：
     * -Xss128k
     */
    private void stackOF() {
        stackLength++;
        stackOF();
    }

    /**
     * 堆内存溢出
     * JVM参数：
     * -Xms20m
     * -Xmx20m
     * -XX:+HeapDumpOnOutOfMemoryError
     */
    private void heapOOM() {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
