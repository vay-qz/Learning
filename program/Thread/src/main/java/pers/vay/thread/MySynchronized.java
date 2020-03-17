package pers.vay.thread;

public class MySynchronized {

    private Object lock = new Object();

    public void testSynchronizedBlock_1() {
        System.out.println("before lock1");
        synchronized (lock) {
            System.out.println("getlock");
            while (true);
        }
    }

    public void testSynchronizedBlock_2() {
        System.out.println("before lock2");
        synchronized (lock) {
            System.out.println("getlock");
            while (true);
        }
    }

    public synchronized void testSynchronized_method() {
        System.out.println("getMethodLock");
        while (true);
    }

    public void testSynchronized_this() {
        System.out.println("getThisLock");
        synchronized (this) {
            while (true);
        }
    }

    public static synchronized void testSynchronizedStatic() {
        System.out.println("getStaticLock");
        while (true);
    }

}
