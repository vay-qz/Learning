package pers.vay.designpattern.create.builder.after;

/**
 * @author qiaozhe
 */
public class Director {

    public Angle construct(AbstractBuilder builder) {
        builder.buildBody();
        builder.buildFace();
        builder.buildWing();
        builder.buildSkin();
        return builder.getAngle();
    }

}
