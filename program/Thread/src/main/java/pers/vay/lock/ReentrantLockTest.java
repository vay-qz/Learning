package pers.vay.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    /**
     * 公平锁，按照申请锁的顺序获得锁，不允许抢占
     * 先开始50个线程申请锁
     * 在50个线程执行时再开始50个线程，之前申请锁的50个线程一定按照顺序获取到锁，后续线程不会抢占已排队的线程
     */
    public void reentrantLock_fairlock_getlock_inorder() {
        Lock lock = new ReentrantLock();
        lock.lock();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new FairReentrantLockThread(lock);
            thread.setName("thread" + i);
            threads.add(thread);
        }
        for (int i = 0; i < 50; i++) {
            threads.get(i).start();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        for (int i = 50; i < 100; i++) {
            threads.get(i).start();
        }
    }

    /**
     * 非公平锁，允许抢占
     * 先开始50个线程申请锁
     * 在50个线程执行时再开始50个线程，后开始的50个线程在获取锁时每次都会试图使用CAS的方法抢占锁
     */
    public void reentrantLock_norfairlock_getlock_inorder() {
        Lock lock = new ReentrantLock(true);
        lock.lock();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new FairReentrantLockThread(lock);
            thread.setName("thread" + i);
            threads.add(thread);
        }
        for (int i = 0; i < 50; i++) {
            threads.get(i).start();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        for (int i = 50; i < 100; i++) {
            threads.get(i).start();
        }
    }

    public void spin_test() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        new Thread(()->lock.lock(), "thread 1").start();
        lock.unlock();
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(1000 * 60 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread 2").start();
    }


    class FairReentrantLockThread extends Thread {
        private Lock lock;

        FairReentrantLockThread(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(this.getName() + " getlock");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
//        reentrantLockTest.reentrantLock_fairlock_getlock_inorder();
//        reentrantLockTest.reentrantLock_norfairlock_getlock_inorder();
        reentrantLockTest.spin_test();
    }
}
