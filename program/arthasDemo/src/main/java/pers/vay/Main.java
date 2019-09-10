package pers.vay;

/**
 * @author qiaozhe
 */
public class Main {

    public static void main(String[] args) {
        ArthasDeadLock demo = new ArthasDeadLock();
        demo.deadLock();
        ArthasStatic arthasStatic = new ArthasStatic();
        new ArthasRedefine().start();
    }

}
