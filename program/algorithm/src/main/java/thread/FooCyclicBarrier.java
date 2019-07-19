package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author qiaozhe
 */
public class FooCyclicBarrier {

    CyclicBarrier second = new CyclicBarrier(2);
    CyclicBarrier third = new CyclicBarrier(2);
    FooCyclicBarrier() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        try {
            second.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            second.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        try {
            third.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            third.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {

    }
}
