package pers.vay.designpattern.action.template_method.after;

/**
 * @author qiaozhe
 */
public abstract class AbstractTransportation {
    public final void drive() {
        boarding();
        fire();
        gun();
        go();
    }

    protected abstract void gun();

    protected abstract void fire();

    protected abstract void boarding();

    private void go() {
        System.out.println(this.getClass().getSimpleName() + " go");
    }
}
