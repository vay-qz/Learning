package pers.vay;



import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThreadExecutePoolTest {

    @Test
    public void test() {
        MyThreadExecutePool executePool = new MyThreadExecutePool(1, 2, 3
                , TimeUnit.NANOSECONDS, new ArrayBlockingQueue<Runnable>(100));
        executePool.execute(new Thread(()->{
            System.out.println("execute");
        }));

    }
}
