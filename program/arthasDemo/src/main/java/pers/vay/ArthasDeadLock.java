package pers.vay;

/**
 * 测试死锁类
 * cmd: thread -b
 * @author qiaozhe
 */
public class ArthasDeadLock {

    Byte[] lock1 = new Byte[1];
    Byte[] lock2 = new Byte[1];

    class LockA extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    System.out.println("get lock1");
                    synchronized (lock2) {
                        System.out.println("get lock1 and lock2");
                    }
                }
            }
        }
    }

    class LockB extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock2) {
                    System.out.println("get lock2");
                    synchronized (lock1) {
                        System.out.println("get lock1 and lock2");
                    }
                }
            }
        }
    }

    public void deadLock() {
        new LockA().start();
        new LockB().start();
    }

}
