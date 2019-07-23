package thread;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class H2O {

    Semaphore hyd = new Semaphore(2);
    Semaphore oxy = new Semaphore(1);

    AtomicInteger time = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hyd.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(time.addAndGet(1) == 2) {
            time.set(0);
            oxy.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxy.acquire();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        hyd.release(2);
    }
}
