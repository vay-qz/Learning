package pers.vay.thread;

import java.util.concurrent.locks.LockSupport;

import static pers.vay.thread.MySynchronized.testSynchronizedStatic;

public class MySynchronizedTest {

    private MySynchronized lock = new MySynchronized();

    public void test1() {
        System.out.println("测试synchronized块");
        new Thread(()->{
            lock.testSynchronizedBlock_1();
        }).start();
        new Thread(()->{
            lock.testSynchronizedBlock_2();
        }).start();
    }

    public void test2() {
        System.out.println("测试sychronized方法和this");
        new Thread(()->lock.testSynchronized_method()).start();
        new Thread(() -> lock.testSynchronized_this()).start();
    }

    public void test3() {
        System.out.println("测试sychronized静态方法");
        new Thread(()->testSynchronizedStatic()).start();
        new Thread(()->testSynchronizedStatic()).start();
    }

    public static void main(String[] args) {
        MySynchronizedTest test = new MySynchronizedTest();
        test.test1();
        LockSupport.parkNanos(1000 * 1000);
        test.test2();
        LockSupport.parkNanos(1000 * 1000);
        test.test3();
    }

}
