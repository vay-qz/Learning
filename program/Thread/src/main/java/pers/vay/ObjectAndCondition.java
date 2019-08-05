package pers.vay;

/**
 * @author qiaozhe
 */
public class ObjectAndCondition {

    public void wait_await() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ObjectAndCondition objectAndCondition = new ObjectAndCondition();
        objectAndCondition.wait_await();
    }

}
