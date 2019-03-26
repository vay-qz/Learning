/**
 * @author qiaozhe
 */
public class VolatileTest {

    private static volatile int vol = 0;
    private static volatile boolean shutdown = false;

    private int NUM = 20;

    public void failTest(){
        for(int i = 0; i < NUM; i++){
            new Thread(()->{
                for(int j = 0; j < 10000; j++){
                    increase();
                }
            }).start();
        }
        while(Thread.activeCount() > 2);
        System.out.println(vol);
    }

    public static void increase(){
        vol++;
    }

    public void successTest(){
        for(int i = 0; i < NUM; i++){
            new Thread(()->{
                while(!shutdown);
            });
        }
        try {
            Thread.sleep(1000);
            System.out.println("over");
            shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown(){
        shutdown = true;
    }


}
