package pers.vay;

import java.util.concurrent.*;

/**
 * @author qiaozhe
 */
public class CallableTest {


    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,1,TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    public void test_future() {
        Future<?> res = executor.submit(new TestCallable());
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void test_futureTask() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new TestCallable());
        executor.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class TestCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            return 1+2;
        }
    }

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        callableTest.test_future();
        callableTest.test_futureTask();
    }

}
