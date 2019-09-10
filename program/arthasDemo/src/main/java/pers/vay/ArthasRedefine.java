package pers.vay;

/**
 * 测试重加载类
 *
 * jad pers.vay.ArthasRedefine --source-only > {path}
 * vi {path}
 * mc {path}
 * redefine {new class}
 *
 * @author qiaozhe
 */
public class ArthasRedefine extends Thread{

    @Override
    public void run() {
        while (true) {
            printProp();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void printProp() {
        System.out.println(System.getProperty("before"));
    }

}
