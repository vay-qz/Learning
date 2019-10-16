package pers.vay.thread;

public class PrintCC {
    private FooCyclicBarrier foo = new FooCyclicBarrier();

    void one(){
        new Thread(()->{
            try {
                foo.first(()-> System.out.println("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    void two(){
        new Thread(()->{
            try {
                foo.second(()-> System.out.println("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void three(){
        new Thread(()->{
            try {
                foo.third(()-> System.out.println("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        PrintCC printCC = new PrintCC();
        new Thread().start();
        printCC.two();
        printCC.one();
        printCC.three();
    }
}
