package thread;


import java.util.concurrent.Semaphore;

class H2O {

    Semaphore hyd = new Semaphore(2);
    Semaphore oxy = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hyd.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxy.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxy.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        hyd.release(2);
    }

    public static void main(String[] args) {
        H2O h2O = new H2O();
        Runnable hyd = ()-> System.out.print("H");
        Runnable oxy = ()-> System.out.print("0");
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                try {
                    h2O.hydrogen(hyd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 50; i++) {
            new Thread(()-> {
            try {
                h2O.oxygen(oxy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }).start();
        }

    }
}
