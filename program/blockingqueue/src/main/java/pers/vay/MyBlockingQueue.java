package pers.vay;

import java.util.concurrent.*;

/**
 * @author qiaozhe
 */
public class MyBlockingQueue {

    private SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<Runnable>();
    private PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
    private DelayQueue<DelayTask> delayQueue = new DelayQueue<DelayTask>();

    public static void main(String[] args) {

    }

    class DelayTask implements Runnable, Delayed {

        public long getDelay(TimeUnit unit) {
            return 0;
        }

        public int compareTo(Delayed o) {
            return 0;
        }

        public void run() {

        }
    }
}
