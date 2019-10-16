package pers.vay.thread;

import java.util.concurrent.Semaphore;

public class FooSeq {
    private Semaphore second;
    private Semaphore third;

    FooSeq() {
        second = new Semaphore(1);
        third = new Semaphore(1);
        try {
            second.acquire();
            third.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.release();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        second.acquire();
    }

    public static void main(String[] args) {
        FooSeq fooSeq = new FooSeq();
        new Thread(()->{
            try {
                fooSeq.second(()-> System.out.println("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fooSeq.third(()->System.out.println("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fooSeq.first(()-> System.out.println("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
