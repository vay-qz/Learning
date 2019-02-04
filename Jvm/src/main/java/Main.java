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
        main.metaSpaceOOM();
//        main.directMemoryOOM();
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
