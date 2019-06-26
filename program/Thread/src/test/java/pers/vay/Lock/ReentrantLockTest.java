package pers.vay.Lock;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    private final static String TARGET_STRING = "1";

    @Test
    public void reentrantLock_same_synchronized_success_get_lock() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Lock lock = new ReentrantLock();
        Thread thread = new ReentrantLockThread(lock, blockingQueue);
        thread.start();
        try {
            Assert.assertEquals(blockingQueue.poll(3, TimeUnit.SECONDS), TARGET_STRING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reentrantLock_same_synchronized_fail_get_lock() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Lock lock = new ReentrantLock();
        lock.lock();
        Thread thread = new ReentrantLockThread(lock, blockingQueue);
        thread.start();
        try {
            Assert.assertNotEquals(blockingQueue.poll(3, TimeUnit.SECONDS), TARGET_STRING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reentrantLock_fairlock_getlock_inorder() throws InterruptedException {
        BlockingQueue<String> results = new ArrayBlockingQueue<>(10);
        //保证线程执行完毕
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Lock lock = new ReentrantLock(true);
        lock.lock();
        StringBuffer origin = new StringBuffer();
        for(int i = 1; i < 5; i++) {
            origin.append("thread" + i);
            Thread thread = new FairReentrantLockThread("thread" + i, lock, results, blockingQueue);
            thread.start();
//            Thread.sleep(500);
        }
        lock.unlock();
        while(blockingQueue.size()!=4);
        StringBuffer now = new StringBuffer();
        for(int i = 0; i < 4; i ++) {
            now.append(results.take());
        }
        Assert.assertEquals(origin.toString(), now.toString());
    }

    @Test
    public void reentrantLock_norfairlock_getlock_inorder() throws InterruptedException {
        BlockingQueue<String> results = new ArrayBlockingQueue<>(100);
        //保证线程执行完毕
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(100);
        Lock lock = new ReentrantLock();
        lock.lock();
        StringBuffer origin = new StringBuffer();
        for(int i = 1; i < 20; i++) {
            origin.append("thread" + i);
            Thread thread = new FairReentrantLockThread("thread" + i, lock, results, blockingQueue);
            thread.start();
            Thread.sleep(500);
        }
        lock.unlock();
        while(blockingQueue.size()!=19);
        StringBuffer now = new StringBuffer();
        for(int i = 0; i < 19; i ++) {
            now.append(results.take());
        }
        Assert.assertNotEquals(origin.toString(), now.toString());
    }

    @Test
    public void condition_same_object() {

    }

    @Test
    public void reentrantLock_canbe_reentry() {

    }

    class ReentrantLockThread extends Thread {
        private Lock lock;
        private BlockingQueue<String> blockingQueue;

        ReentrantLockThread(Lock lock, BlockingQueue<String> blockingQueue) {
            this.lock = lock;
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                if(this.lock.tryLock(2, TimeUnit.SECONDS)) {
                    this.blockingQueue.offer(TARGET_STRING);
                    System.out.println(this);
                }else {
                    System.out.println(this + " getlock fail");
                }
            } catch (InterruptedException e) {
                System.out.println(this + " getlock fail");
            } finally {
                this.lock.unlock();
            }
        }
    }

    class FairReentrantLockThread extends Thread {
        private Lock lock;
        private BlockingQueue<String> results;
        private BlockingQueue<String> blockingQueue;

        FairReentrantLockThread(String name, Lock lock, BlockingQueue results, BlockingQueue blockingQueue) {
            super(name);
            this.lock = lock;
            this.results = results;
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                results.offer(this.getName());
                blockingQueue.offer("1");
            } finally {
                lock.unlock();
            }
        }

    }

}
