package pers.vay.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public void test(int time) {
        CyclicBarrier semaphore = new CyclicBarrier(3);
        Runnable runnable = ()->{
            try {
                semaphore.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("get");
        };
        for(int i = 0; i < time; i++) {
            new Thread(runnable).start();
        }
        System.out.println(time + " is ok");
    }

    public static void main(String[] args) {
        CyclicBarrierTest semaphoreTest = new CyclicBarrierTest();
        semaphoreTest.test(3);
//        semaphoreTest.test(5);
    }
}
