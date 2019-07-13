package pers.vay.designpattern.action.template_method.after;

/**
 * @author qiaozhe
 */
public class Car extends AbstractTransportation {


    @Override
    protected void gun() {
        System.out.println("Step on the gas pedal");
    }

    @Override
    protected void fire() {
        System.out.println("Screw the key");

    }

    @Override
    protected void boarding() {
        System.out.println("Sitting in the car");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
