package pers.vay.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

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

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        reentrantLockTest.reentrantLock_fairlock_getlock_inorder();
        reentrantLockTest.reentrantLock_norfairlock_getlock_inorder();
    }
}
