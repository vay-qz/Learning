package pers.vay.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public void lock() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
        lock.writeLock().lock();
        new Thread(()->{
            lock.readLock().lock();
            System.out.println("thread 1");
        }, "thread 1").start();
        new Thread(()->{
            lock.readLock().lock();
            System.out.println("thread 2");
        },"thread 2").start();
        new Thread(()->{
            lock.writeLock().lock();
            System.out.println("thread 3");
        }, "thread 3").start();
        new Thread(()->{
            lock.readLock().lock();
            System.out.println("thread 4");
        },"thread 4").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
    }


    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        readWriteLockTest.lock();
    }
}
