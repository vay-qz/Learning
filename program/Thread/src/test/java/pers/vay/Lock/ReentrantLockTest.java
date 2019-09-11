package pers.vay.Lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReentrantLockTest {

    private final static String TARGET_STRING = "1";

    @Test
    public void reentrantLock_same_synchronized_success_get_lock() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Lock lock = new ReentrantLock();
        Thread thread = new ReentrantLockThread(lock, blockingQueue);
        thread.start();
        try {
            assertEquals(blockingQueue.poll(3, TimeUnit.SECONDS), TARGET_STRING);
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
            assertNotEquals(blockingQueue.poll(3, TimeUnit.SECONDS), TARGET_STRING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reentrantLock_canbe_reentry() throws InterruptedException {
        BlockingQueue<Object> result = new ArrayBlockingQueue<Object>(10);
        ReentrantThread thread = new ReentrantThread(result);
        thread.start();
        int i = 0;
        while (thread.getState() != Thread.State.TERMINATED){
            if(i > 5){
                break;
            }
            Thread.sleep(1000);
        }
        assertEquals(result.size(), 2);

    }

    @Test
    public void condition_same_object() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Condition condition = lock.newCondition();
        new ConditionThread(condition, lock).start();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ReentrantReadWriteLock_ReadLock_Share() throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        Thread thread1 = new ReentrantReadLockThread(readLock, blockingQueue);
        Thread thread2 = new ReentrantReadLockThread(readLock, blockingQueue);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(blockingQueue.size(), 2);
    }

    @Test
    public void ReentrantReadWriteLock_ReadLock_WriteCantLock() throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        readLock.lock();
        Thread thread = new Thread(()->{
            readWriteLock.writeLock().lock();
            blockingQueue.offer(new Object());
        });
        thread.start();
        Thread.sleep(1000);
        assertEquals(blockingQueue.size(), 0);
    }

    class ReentrantReadLockThread extends Thread {
        ReentrantReadWriteLock.ReadLock readLock;
        BlockingQueue blockingQueue;
        public ReentrantReadLockThread(ReentrantReadWriteLock.ReadLock readLock, BlockingQueue blockingQueue) {
            this.readLock = readLock;
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            readLock.lock();
            blockingQueue.offer(new Object());
        }
    }

    class ConditionThread extends Thread {
        Condition condition;
        Lock lock;

        ConditionThread(Condition condition, Lock lock) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
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

    class ReentrantThread extends Thread {
        private Lock lock = new ReentrantLock();
        private BlockingQueue blockingQueue;
        ReentrantThread(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }
        @Override
        public void run() {
            try {
                lock.lock();
                blockingQueue.offer(new Object());
                try {
                    lock.lock();
                    blockingQueue.offer(new Object());
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }
    }

}
