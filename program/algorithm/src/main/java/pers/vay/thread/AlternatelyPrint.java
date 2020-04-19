package pers.vay.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatelyPrint {
    private Thread a1 = null;
    private Thread a2 = null;

    private void lockSupport() throws InterruptedException {
        a1 = new Thread(()->{
            char[] tmp = new char[]{'a', 'b', 'c'};
            for (int i = 0; i < tmp.length; i++) {
                LockSupport.park();
                System.out.println(tmp[i]);
                LockSupport.unpark(a2);
            }
        }, "lockSupport1");
        a1.start();

        a2 = new Thread(()->{
            int[] tmp = new int[]{1,2,3};
            for (int i = 0; i < tmp.length; i++) {
                System.out.println(tmp[i]);
                LockSupport.unpark(a1);
                LockSupport.park();
            }
        }, "lockSupport2");
        a2.start();
    }

    private void synclock() {
        Object lock = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            char[] tmp = new char[]{'a', 'b', 'c'};
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "synclock1").start();

        new Thread(()->{
            int[] tmp = new int[]{1,2,3};
            synchronized (lock) {
                countDownLatch.countDown();
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "synclock2").start();
    }

    public void lock1() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            char[] tmp = new char[]{'a', 'b', 'c'};
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    condition1.signal();
                    condition1.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "lock11").start();

        new Thread(()->{
            int[] tmp = new int[]{1,2,3};
            try {
                lock.lock();
                countDownLatch.countDown();
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    condition1.signal();
                    condition1.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "lock12").start();
    }

    public void lock2() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            char[] tmp = new char[]{'a', 'b', 'c'};
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
                lock.unlock();
            }
        }, "lock21").start();

        new Thread(()->{
            int[] tmp = new int[]{1,2,3};
            try {
                lock.lock();
                countDownLatch.countDown();
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i]);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "lock22").start();
    }

    public static void main(String[] args) throws Exception {
        AlternatelyPrint print = new AlternatelyPrint();
//        print.lockSupport();
//        System.out.println();
//        print.synclock();
//        System.out.println();
//        print.lock1();
//        System.out.println();
        print.lock2();
    }
}
