package pers.vay.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(()->{
            LockSupport.park(this);
            System.out.println("be interrupt");
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    public static void main(String[] args) {
        LockSupportTest test = new LockSupportTest();
        try {
            test.testInterrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
