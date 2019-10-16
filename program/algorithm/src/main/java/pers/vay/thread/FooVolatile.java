package pers.vay.thread;

public class FooVolatile {
    private volatile int a = 1;
    public FooVolatile() {

    }
    public void first(Runnable printFirst) throws InterruptedException {
        while(a!=1){}
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a=2;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(a!=2){}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        a=3;
    }

    public void third(Runnable printThird) throws InterruptedException {

        while(a!=3){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
