package pers.vay.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public void test(int time) {
        CountDownLatch semaphore = new CountDownLatch(3);
        Runnable runnable = ()->{
            semaphore.countDown();
            System.out.println("get");
        };
        for(int i = 0; i < time; i++) {
            new Thread(runnable).start();
        }
        try {
            semaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(time + " is ok");
    }

    public static void main(String[] args) {
        CountDownLatchTest semaphoreTest = new CountDownLatchTest();
        semaphoreTest.test(5);
//        semaphoreTest.test(5);
    }
}
