package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qiaozhe
 */
public class JVMToolsTest {
    private Object obj = new Object();
    static class  OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList();
        for(int i = 0; i < num; i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
        //阻塞暂停以便观察
        LockSupport.park();
    }

    public static void main(String[] args)throws Exception {
//        fillHeap(1000);
        JVMToolsTest main = new JVMToolsTest();
        main.createBlockThread();
        main.createBusyThread();
        main.createDeadBlockThread();
    }

    public void createBusyThread(){
        new Thread(()->{
            while (true);
        },"testBusy").start();
    }

    public void createBlockThread(){
        new Thread(()->{
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testBlock").start();
    }

    public void createDeadBlockThread(){
        for(int i = 0; i < 10; i++){
            new Thread(new SynRunable(1, 2)).start();
            new Thread(new SynRunable(2, 1)).start();
        }
    }

    class SynRunable implements Runnable{
        int a,b;
        public SynRunable(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }
}
