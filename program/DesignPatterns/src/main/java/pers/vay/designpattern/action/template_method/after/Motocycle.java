package pers.vay.designpattern.action.template_method.after;

public class Motocycle extends AbstractTransportation{

    @Override
    protected void gun() {
        System.out.println("Twist the handlebar");
    }

    @Override
    protected void fire() {
        System.out.println("Step on the pedal");

    }

    @Override
    protected void boarding() {
        System.out.println("Sitting on the motorcycle");
    }

    public static void main(String[] args) {
        Motocycle motocycle = new Motocycle();
        motocycle.drive();
    }

}
