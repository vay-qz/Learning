package pers.vay.designpattern.action.template_method.before;

/**
 * @author qiaozhe
 */
public class Car {
    public void drive() {
        boarding();
        fire();
        gun();
        go();
    }

    private void go() {
        System.out.println(this.getClass().getSimpleName() + " go");
    }

    private void gun() {
        System.out.println("Step on the gas pedal");
    }

    private void fire() {
        System.out.println("Screw the key");

    }

    private void boarding() {
        System.out.println("Sitting in the car");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }

}
