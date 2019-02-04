import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    /**
     * 公平锁
     */
    private ReentrantLock fairLock = new ReentrantLock(true);

    /**
     * 非公平锁
     */
    private ReentrantLock noneFairLock = new ReentrantLock();
    private Condition condition = noneFairLock.newCondition();

    private Object lock = new Object();

    public static void main(String[] args) {
        Main main = new Main();
//        main.testFairLock();
//        main.testReentrantLock();
//        main.testInterrupt();
//        main.testCondition();
//        main.testUnlockFirst();
    }

    /**
     * 尝试先解锁
     * 结论：不可，解锁需要判断是否是锁的独占线程，独占线程未上锁时为null
     */
    private void testUnlockFirst() {
        new Thread(()->{
            noneFairLock.unlock();
            noneFairLock.lock();
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        noneFairLock.lock();
    }

    private void testCondition() {
        new Thread(()->{
            noneFairLock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                noneFairLock.unlock();
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        noneFairLock.lock();
        try{
            condition.signal();
        }finally {
            noneFairLock.unlock();
        }
    }


    /**
     * lock()方法不响应中断，lockInterruptibly()才响应
     */
    private void testInterrupt() {
        new ReenTranLockThread().start();
        Thread a = new Thread(()->{
            try {
                noneFairLock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("获取锁时被中断了");
            }
        });
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }

    /**
     * ReentrantLock和synchronized块都是可重入的，ReentrantLock由代码控制释放锁
     */
    private void testReentrantLock() {
        new ReenTranLockThread().start();
        new Thread(()-> System.out.println("尝试获取锁" + noneFairLock.tryLock())).start();
        synchronized (lock){
            System.out.println("第一次获取到锁");
            synchronized (lock){
                System.out.println("第二次获取到锁");
            }
        }
    }

    private void testFairLock() {
        System.out.println("公平锁演示");
        Thread fair1 = new FairLockTestThread(fairLock, 100);
        Thread fair2 = new FairLockTestThread(fairLock, 100);
        fair1.start();
        fair2.start();
        System.out.println("稳定后按照请求顺序获取锁");
        try {
            fair1.join();
            fair2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非公平锁演示");
        new FairLockTestThread(noneFairLock, 500).start();
        new FairLockTestThread(noneFairLock, 500).start();
        System.out.println("抢占式获取锁");
    }

    class FairLockTestThread extends Thread{
        private ReentrantLock lock;
        private int num;

        public FairLockTestThread(ReentrantLock lock, int num){
            this.lock = lock;
            this.num = num;
        }
        @Override
        public void run() {
            for(int i = 0; i < num; i++){
                lock.lock();
                try{
                    System.out.println(this);
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class ReenTranLockThread extends Thread{
        @Override
        public void run() {
            noneFairLock.lock();
            noneFairLock.lock();
            System.out.println(this + "加了两把锁");
            try {
            } finally {
                noneFairLock.unlock();
                System.out.println(this + "释放了一把锁 ");
            }
        }
    }

}
