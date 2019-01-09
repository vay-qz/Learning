import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    BlockingQueue a = new ArrayBlockingQueue(2);
    BlockingQueue b = new ArrayBlockingQueue(2);
    Object lock = new Object();

    public static void main(String[] args) {
        Main main = new Main();
//        main.testState();
//        main.testYield();
//        main.testSleep1();
//        main.testSleep2();
//        main.testJoin();
        main.testInterrupt();
//        main.testUncaught();
    }

    private void testUncaught() {
        Thread testUncaught = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = "";
                System.out.println(str.charAt(1));
            }
        });
        testUncaught.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t);
                e.printStackTrace();
            }
        });
        testUncaught.start();
    }

    private void testInterrupt() {
        Thread testWait = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("testWait thread be interrupted");
                    }
                }
            }
        });
        testWait.start();
        interruptAndPrint(testWait);

        Thread testSleep = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("testSleep thread be interrupted");
                }
            }
        });
        testSleep.start();
        interruptAndPrint(testSleep);

        Join testJoin = new Join(new Thread(new Runnable() {
            @Override
            public void run() {
                while(true);
            }
        }));
        testJoin.start();
        interruptAndPrint(testJoin);

        Thread test = new TestInte();
        test.start();
        interruptAndPrint(test);

//        Thread testIO = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    a.take();
//                } catch (InterruptedException e) {
//                    System.out.println("testSleep thread be interrupted");
//                }
//            }
//        });
//        testIO.start();
//        interruptAndPrint(testIO);

        //NIO相关
    }

    private void interruptAndPrint(Thread testWait) {
        waitAMoment();
        System.out.println("中断前interrupted状态:" + testWait.isInterrupted());
        testWait.interrupt();
//        waitAMoment();
//        System.out.println("中断后interrupted状态:" + testWait.isInterrupted());
    }

    public void testJoin(){
        Join testJoin = new Join(new Thread(new Runnable() {
            @Override
            public void run() {
                while(true);
            }
        }));
        testJoin.start();
        waitAMoment();
        //抛弃领导
//        testJoin.interrupt();
    }

    public void testSleep2() {
        //场景二：
        Thread tryGetLock = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("commonPeople:多谢恩赐");
                }
            }
        });
        Thread god = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("god:我睡20分钟，锁睡醒了就能给你");
                        Thread.sleep(1000 * 60 * 20);
                        System.out.println("god:睡醒了给你");
                    } catch (InterruptedException e) {
                        System.out.println("god:锁给你，剩下的活我不干了");
                        e.printStackTrace();
                    }
                }
            }
        });
        god.start();
        tryGetLock.start();
        waitAMoment();
        System.out.println("commonPeople:不行，god睡太久了，宁愿剩下的事情他不做也得得到锁");
        waitAMoment();
        god.interrupt();
    }

    public void testSleep1(){
        //场景一：
        Thread tryGetLock1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("commonPeople:多谢恩赐");
                }
            }
        });
        Thread god = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("god:我先睡一会儿，锁睡醒才能给你");
                        Thread.sleep(5000);
                        System.out.println("god:睡醒了给你");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        god.start();
        tryGetLock1.start();
    }

    public void testYield(){
        Thread tryGetLock = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("我得到锁了");
                }
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("开始无限循环");
                    while(true){
                        Thread.yield();
                    }
                }
            }
        });
        thread.start();
        waitAMoment();
        tryGetLock.start();
    }

    public void testState(){
        init();

        Thread thread = new TestThread();
        printThreadState(thread);
        thread.start();
        printThreadState(thread);
        waitAMoment();
        printThreadState(thread);
        a.add(1);
        waitAMoment();
        printThreadState(thread);
        b.add("1");
        waitAMoment();
        printThreadState(thread);
        thread.interrupt();

    }

    private void printThreadState(Thread thread) {
        System.out.println(thread.getState());
    }

    private void waitAMoment() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    private void init() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                addLock();
            }
        }).start();
    }

    private void addLock() {
        synchronized (lock){
            try {
                b.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class TestThread extends Thread{
        @Override
        public void run() {
            try {
                a.take();
                synchronized (lock){
                    System.out.println("我获取到锁");
                }
                sleep(5000);
            }catch (InterruptedException e){
                System.out.println("我被中断了");
            }
        }
    }

    class TestInte extends Thread{
        @Override
        public void run() {
            while(!isInterrupted());
            System.out.println(isInterrupted());
        }
    }
}
