package pers.vay;

public class Join extends Thread{
    private Thread leader;

    public Join(Thread thread){
        this.leader = thread;
    }

    @Override
    public void run() {
        try {
            leader.start();
            System.out.println("让领导先走，我断后");
            Thread.sleep(1000);
            leader.join();
            System.out.println("领导你走得太慢了");
        } catch (InterruptedException e) {
            System.out.println("领导你走太慢了我先走了");
//            Thread.interrupted();
//            System.out.println("重置中断状态：" + this.isInterrupted());
        }
    }
}
