import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class Main {

    BlockingQueue a = new ArrayBlockingQueue(2);
    BlockingQueue b = new ArrayBlockingQueue(2);
    Object lock = new Object();

    String path = "E:/github/testWrite.txt";

    public static void main(String[] args) {
        Main main = new Main();
//        main.testState();
//        main.testYield();
//        main.testSleep1();
//        main.testSleep2();
//        main.testJoin();
//        main.testInterrupt();
//        main.testUncaught();
//        main.testNIO();
//        main.testLockSupport();
        VolatileTest volatileTest = new VolatileTest();
//        volatileTest.failTest();
        volatileTest.successTest();
//        main.testPermitBug();
    }

    private void testPermitBug() {
        Thread thread1 = new Thread(()->{
            try {
                synchronized (lock){
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("睡眠被中断");
            }
        });
        thread1.start();
        waitAMoment();
        thread1.interrupt();

        Thread thread332 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("over");
        });
        thread332.start();
        waitAMoment();
        printThreadState(thread332);
    }

    private void testNIO(){
        testSelector();
        testFileChannel();
    }

    private void testFileChannel() {
        FileChannel fileChannel = null;
        FileThread thread = new FileThread(fileChannel);
        thread.start();
        waitAMoment();
        try {
            fileChannel.close();
        } catch (IOException e) {
        }catch (NullPointerException e){
        }
    }

    class FileThread extends Thread{

        private FileChannel fileChannel;

        public FileThread(FileChannel fileChannel){
            this.fileChannel = fileChannel;
        }
        @Override
        public void run() {
            try{
                fileChannel = new FileInputStream("").getChannel();
                while(true);
            }catch (IOException e){
                System.out.println("被外部中断了");
            }
        }
    }

    private void testSelector() {
        Thread selectorTest = new Thread(()->{
            try {
                Selector selector = Selector.open();
                selector.select();
            } catch (IOException e) {
                System.out.println("被外部中断");
            }
        });
        selectorTest.start();
        waitAMoment();
        selectorTest.interrupt();
        System.out.println(selectorTest.isInterrupted());
    }

    private void testUncaught() {
        Thread testUncaught = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = "";
                System.out.println(str.charAt(1));
            }
        });
        Thread.setDefaultUncaughtExceptionHandler((t,e)->System.out.println(t));
        testUncaught.setUncaughtExceptionHandler((t,e)->System.out.println(t + " not default"));
//        testUncaught.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println(t);
//                e.printStackTrace();
//            }
//        });
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
        synchronized (lock){
            lock.notifyAll();
        }
        waitAMoment();
        printThreadState(thread);
        thread.interrupt();
    }

    private void testLockSupport() {
        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("结束了");
        });
        thread2.start();
//        LockSupport.unpark(thread2);
        waitAMoment();
        printThreadState(thread2);
        waitAMoment();
        LockSupport.unpark(thread2);
    }

    private void printThreadState(Thread thread) {
        System.out.println(thread.getState());
    }

    private void waitAMoment() {
        try {
            Thread.sleep(1000);
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
//                    lock.wait();
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
