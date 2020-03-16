package pers.vay.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadTest {

    private Object lock = new Object();

    public void waitTiming() {
        Thread thread = new Thread(()->{
            synchronized (lock) {
                try {
                    lock.wait(1000 * 60);
                    System.out.println("unwait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        LockSupport.parkNanos(1000 * 1000);
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public void parkTiming() {
        Thread thread = new Thread(()->{
            LockSupport.parkNanos(1000 * 1000);
            System.out.println("unpark");
        });
        thread.start();

        LockSupport.unpark(thread);
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.waitTiming();
        test.parkTiming();
        LockSupport.park();
    }

}
