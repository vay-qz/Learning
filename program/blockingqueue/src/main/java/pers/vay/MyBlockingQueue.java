package pers.vay;

import java.util.concurrent.*;

/**
 * @author qiaozhe
 */
public class MyBlockingQueue {

    private SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<Runnable>();
    private PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
    private DelayQueue delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        myBlockingQueue.testDelay();

    }

    public void testDelay() {
        ThreadPoolExecutor delay = new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, delayQueue);
        delay.prestartAllCoreThreads();
        delay.execute(new DelayTask(1000*1000));
        delay.execute(new DelayTask(50));
        delay.execute(new DelayTask(1));
        delay.shutdown();

    }

    class DelayTask implements Runnable, Delayed {

        private long excuteTime;

        public DelayTask(long executeTime) {
            this.excuteTime = executeTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.excuteTime - System.currentTimeMillis() , TimeUnit.SECONDS);
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
}
