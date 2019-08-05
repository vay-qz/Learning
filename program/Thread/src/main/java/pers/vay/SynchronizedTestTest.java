package pers.vay;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

public class SynchronizedTestTest {

    public void synchronized_block_object_method_conflict() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        SynchronizedTest test = new SynchronizedTest();
        new Thread(()->test.synchronized_block_object(blockingQueue)).start();
        new Thread(()->test.synchronized_method(blockingQueue)).start();
        LockSupport.parkNanos(1000000 * 1);
        if(blockingQueue.size()==1) {
            System.out.println("同步代码块以this为锁与同步方法获取的锁是同一个锁，互斥");
        }
    }

    public void synchronized_block_class_static_conflict() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        SynchronizedTest test = new SynchronizedTest();
        new Thread(()->test.synchronized_block_class(blockingQueue)).start();
        new Thread(()->SynchronizedTest.synchronized_static_method(blockingQueue)).start();
        LockSupport.parkNanos(1000000 * 1);
        if(blockingQueue.size()==1) {
            System.out.println("同步代码块以XXX.class为锁与静态同步方法获取的锁是同一个锁，互斥");
        }
    }

    public void synchronized_static_method_not_conflict() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        SynchronizedTest test = new SynchronizedTest();
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> SynchronizedTest.synchronized_static_method_notPark(blockingQueue, semaphore)).start();

        new Thread(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.synchronized_block_object2(blockingQueue);
        }).start();
        LockSupport.parkNanos(1000000 * 1);
        if(blockingQueue.size()==2) {
            System.out.println("同步代码块以XXX.class为锁与同步方法获取的锁不是同一个锁，不互斥，且类锁不影响对象锁的获取");
        }
    }

    public static void main(String[] args) {
        SynchronizedTestTest test = new SynchronizedTestTest();
//        test.synchronized_block_class_static_conflict();
//        test.synchronized_block_object_method_conflict();
        test.synchronized_static_method_not_conflict();
    }


}
