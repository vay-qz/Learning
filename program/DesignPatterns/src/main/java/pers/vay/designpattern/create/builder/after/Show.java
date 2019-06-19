package pers.vay.designpattern.create.builder.after;


/**
 * @author qiaozhe
 */
public class Show {

    public void showRolesLook() {
        Angle angle = getAngle();
        angle.show();
        Angle angleWithoutWing = getAngleWithoutWing();
        angleWithoutWing.show();
    }

    private Angle getAngleWithoutWing() {
        DirectorWithoutWing director = new DirectorWithoutWing();
        AbstractBuilder angleBuilder = new AngleBuilder();
        return director.construct(angleBuilder);
    }

    private Angle getAngle() {
        Director director = new Director();
        AbstractBuilder angleBuilder = new AngleBuilder();
        return director.construct(angleBuilder);
    }

}
