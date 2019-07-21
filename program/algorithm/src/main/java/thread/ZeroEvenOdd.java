package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {

    private int n;

    private AtomicInteger source;

    public ZeroEvenOdd(int n) {
        this.n = n;
        source = new AtomicInteger(1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(source.get());

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);

    }
}
