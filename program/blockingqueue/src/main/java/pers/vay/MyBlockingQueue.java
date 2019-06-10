package pers.vay;

import java.util.concurrent.*;

/**
 * @author qiaozhe
 */
public class MyBlockingQueue {

    private PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
    private DelayQueue delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        myBlockingQueue.testDelay();
        myBlockingQueue.testPriority();
    }

    private void testPriority() {
        ThreadPoolExecutor priority = new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS, priorityBlockingQueue);
        priority.prestartAllCoreThreads();
        priority.execute(new PriorityTest(1));
        priority.execute(new PriorityTest(2));
        priority.execute(new PriorityTest(3));
        priority.shutdown();
    }

    public void testDelay() {
        ThreadPoolExecutor delay = new ThreadPoolExecutor(2, 2, 100, TimeUnit.SECONDS, delayQueue);
        delay.prestartAllCoreThreads();
        delay.execute(new DelayTask(1000 * 6));
        delay.execute(new DelayTask(1000 * 3));
        delay.execute(new DelayTask(1000 * 1));
        delay.shutdown();

    }

    class DelayTask implements Runnable, Delayed {

        private long excuteTime;

        public DelayTask(long executeTime) {
            this.excuteTime = executeTime + System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.excuteTime - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            DelayTask msg = (DelayTask)o;
            return this.excuteTime>msg.excuteTime?1:( this.excuteTime<msg.excuteTime?-1:0);
        }

        @Override
        public void run() {
            System.out.println(this.excuteTime);
        }
    }

    class PriorityTest implements Comparable, Runnable {

        private long priority;

        public PriorityTest(long p) {
            this.priority = p;
        }

        @Override
        public int compareTo(Object o) {
            PriorityTest test = (PriorityTest)o;
            return this.priority > test.priority ? -1 : 1;
        }

        @Override
        public void run() {
            System.out.println(this.priority);
        }
    }

}
