package pers.vay.ref;

import java.lang.ref.*;

public class ReferenceTest {

    private ReferenceQueue<String> queue;

    /**
     * 软引用测试
     * <p>
     *     -Xms10m
     *     -Xmx10m
     * </p>
     */
    public void SoftRefTest() {
        SoftReference<String> s = new SoftReference<>(new String(new byte[2 * 1024 * 1024]), queue);
        byte[] a = new byte[4 * 1024 * 1024];
        System.out.println(s.get()==null?"软引用已被回收":s.get());
    }

    public void WeakRefTest() {
        WeakReference<String> a = new WeakReference<>(new String("weak"), queue);
        System.gc();
        System.out.println(a.get()==null?"弱引用已被回收":a.get());
    }

    public void phantomRefTest(String str) {
        PhantomReference<String> a = new PhantomReference<>(str, queue);
    }

    public void init() {
        queue = new ReferenceQueue<>();
        new Thread(()->{
            while(true) {
                Reference ref = queue.poll();
                if(ref != null){
                    System.out.println("回收触发gc");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        ReferenceTest test = new ReferenceTest();
        test.init();
        test.SoftRefTest();
        test.WeakRefTest();
    }
}
