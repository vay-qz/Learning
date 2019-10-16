package pers.vay.thread;

class FooBar {
    private int n;
    private volatile int flag = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(flag!=0){}
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(flag!=1){}
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = 0;
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Runnable printFoo = ()-> System.out.print("foo");
        Runnable printBar = ()-> System.out.print("bar");
        new Thread(()->{
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
