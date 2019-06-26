package pers.vay.Lock;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
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
    public void condition_same_object() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

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

}
