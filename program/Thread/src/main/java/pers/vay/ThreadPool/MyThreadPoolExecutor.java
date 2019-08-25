package pers.vay.ThreadPool;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyThreadPoolExecutor extends AbstractExecutorService {

    private int core;
    private int max;
    private int overtime;
    private int timeUnot;
    private BlockingQueue queue;
    private RejectedExecutionHandler handler;

    public MyThreadPoolExecutor(int core, int max, int overtime, int TimeUnit, BlockingQueue queue, RejectedExecutionHandler handler) {
        this.core = core;
        this.max = max;
        this.overtime = overtime;
        this.timeUnot = TimeUnit;
        this.queue = queue;
        this.handler = handler;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {

    }

    class MyWorker extends AbstractQueuedSynchronizer {



        void runWorker() {

        }
    }

}
