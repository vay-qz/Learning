import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
//        main.testAllocation();
//        main.testPretenureSizeThreshold();
//        main.testTenuringThreshold();
//        main.testTenuringThreshold2();
        BlockingQueue a = new ArrayBlockingQueue(1);
        a.take();
    }

    /**
     * 测试年龄
     * 参数：
     * -Xms40M
     * -Xmx40M
     * -Xmn20M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     * -XX:+UseSerialGC
     */
    private void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;

        allocation1 = new byte[1024*1024/32];
        allocation2 = new byte[8 * 1024*1024];
        allocation3 = new byte[8 * 1024*1024];
        allocation3 = null;
        allocation3 = new byte[8 * 1024*1024];

    }

    /**
     * 动态年龄判断
     * 参数：
     * -Xms80M
     * -Xmx80M
     * -Xmn20M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseSerialGC
     */
    private void testTenuringThreshold2(){
        byte[] allocation1,allocation2 = null,allocation3 = null,allocation4, allocation5,allocation6, allocation7 = null, allocation8 = null,allocation9,allocation10;
        //年龄最大的
        allocation1 = new byte[1024*1024/16];
        minorGc(allocation2,allocation3);
//        //年龄第二大的
        allocation4 = new byte[1024*1024 / 16];
        allocation5 = new byte[1024*1024 / 16];

        allocation6 = new byte[1024*1024 * 10];
        allocation7 = new byte[1024*1024 * 10];

        allocation8 = new byte[1024*1024 / 4];

        allocation9 = new byte[1024*1024 * 10];
        allocation10 = new byte[1024*1024 * 10];

    }

    /**
     * 触发minor gc
     * @param allocation
     */
    private void minorGc(byte[] allocation, byte[] allocation2) {
        allocation = new byte[1024*1024 * 10];
        allocation2 = new byte[1024*1024 * 10];
    }

    /**
     * 测试大对象直接进入老年代
     * 参数:
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * -XX:+UseSerialGC
     */
    private void testPretenureSizeThreshold(){
        byte[] allocation1;
        allocation1 = new byte[4 * 1024*1024];
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
     */
    private void testAllocation() {
        byte[] allocation1,allocation2,allocation3;

        allocation2 = new byte[3 * 1024*1024];

        allocation3 = new byte[5 * 1024*1024];
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
