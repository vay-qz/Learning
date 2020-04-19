package pers.vay.thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

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
        test.test1();
    }


    public Object obj = new Object();

    public void syncLock () {
        synchronized (obj) {
            while (true);
        }
    }

    public void test1 () {
        Thread a = new Thread(()->{
            syncLock();
        });
        Thread b = new Thread(()->{
            syncLock();
        });
        a.start();
        park1s();
        b.start();
//        b.interrupt();
        park1s();
        System.out.println(a.getState());
        System.out.println(b.getState());
    }

    public void test2() {
        ReentrantLock lock = new ReentrantLock();

    }

    public void park1s() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
