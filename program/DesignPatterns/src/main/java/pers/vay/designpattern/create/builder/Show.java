package pers.vay.designpattern.create.builder;


/**
 * @author qiaozhe
 */
public class Show {

    public void showRolesLook() {
        Angle angle = getAngle();
        angle.show();
    }

    private Angle getAngle() {
        AbstractBuilder builder = new AngleBuilder();
        Director director = new Director();
        return builder.construct();
    }

}
