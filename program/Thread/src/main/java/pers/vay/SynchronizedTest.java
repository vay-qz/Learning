package pers.vay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qiaozhe
 */
public  class SynchronizedTest {
    private Object lock = new Object();

    public void synchronized_block_object(BlockingQueue<Integer> blockingQueue) {
        synchronized (this) {
            blockingQueue.add(1);
            LockSupport.park();
        }
    }

    public void synchronized_block_object2(BlockingQueue<Integer> blockingQueue) {
        SynchronizedTest test = new SynchronizedTest();
        synchronized (test) {
            blockingQueue.add(1);
            LockSupport.park();
        }
    }

    public synchronized void synchronized_method(BlockingQueue<Integer> blockingQueue) {
        blockingQueue.add(1);
        LockSupport.park();
    }

    public static synchronized void synchronized_static_method(BlockingQueue<Integer> blockingQueue) {
        blockingQueue.add(1);
        LockSupport.park();
    }

    public static synchronized void synchronized_static_method_notPark(BlockingQueue<Integer> blockingQueue, Semaphore semaphore) {
        blockingQueue.add(1);
        semaphore.release();
        LockSupport.park();
    }

    public void synchronized_block_class(BlockingQueue<Integer> blockingQueue) {
        synchronized (SynchronizedTest.class) {
            blockingQueue.add(1);
            LockSupport.park();
        }
    }


}
