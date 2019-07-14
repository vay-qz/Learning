package pers.vay.aqs;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public void test() {
        Semaphore semaphore = new Semaphore(3);
        Runnable runnable = ()->{
            try {
                semaphore.acquire();
                System.out.println("get");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        };
        for(int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.test();
    }

}
