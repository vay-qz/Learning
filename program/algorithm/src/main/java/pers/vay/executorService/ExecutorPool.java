package pers.vay.executorService;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class ExecutorPool {

    public void exec() throws Exception {
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                3,
                3,
                3000,
                TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    String preName = "pool-";
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(preName + thread.getName());
                        return thread;
                    }
                }
        );
        Thread thread = new Thread(()->{
            LockSupport.park();
        }, "testName");
        service.prestartAllCoreThreads();
        service.execute(thread);
        Thread.sleep(1000);
        service.shutdown();
    }

    public static void main(String[] args) throws Exception {
        ExecutorPool pool = new ExecutorPool();
        pool.exec();
    }

}
