package pers.vay.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZeroEvenOdd {

    private int n;

    private BlockingQueue<Integer> zeroQueue = new LinkedBlockingQueue();

    private BlockingQueue<Integer> evenQueue = new LinkedBlockingQueue();

    private BlockingQueue<Integer> oddQueue = new LinkedBlockingQueue<>();

    public ZeroEvenOdd(int n) {
        this.n = n;
        try {
            zeroQueue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroQueue.take();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddQueue.put(i + 1);
            }else{
                evenQueue.put(i + 1);
            }
        }
        oddQueue.put(-1);
        evenQueue.put(-1);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        doing(printNumber, evenQueue);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        doing(printNumber, oddQueue);
    }

    private void doing(IntConsumer printNumber, BlockingQueue<Integer> evenQueue) throws InterruptedException {
        while (true) {
            int t = evenQueue.take();
            if(t == -1) {
                break;
            }
            printNumber.accept(Integer.valueOf(t));
            zeroQueue.put(1);
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(()->{
            try {
                zeroEvenOdd.even(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.zero(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.odd(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
