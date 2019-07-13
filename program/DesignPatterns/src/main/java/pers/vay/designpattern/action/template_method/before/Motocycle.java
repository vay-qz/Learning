package pers.vay.designpattern.action.template_method.before;

public class Motocycle {

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
        System.out.println("Twist the handlebar");
    }

    private void fire() {
        System.out.println("Step on the pedal");

    }

    private void boarding() {
        System.out.println("Sitting on the motorcycle");
    }

    public static void main(String[] args) {
        Motocycle motocycle = new Motocycle();
        motocycle.drive();
    }

}
