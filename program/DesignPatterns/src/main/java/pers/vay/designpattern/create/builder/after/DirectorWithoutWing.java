package pers.vay.designpattern.create.builder.after;

/**
 * @author qiaozhe
 */
public class DirectorWithoutWing {

    public Angle construct(AbstractBuilder builder) {
        builder.buildBody();
        builder.buildFace();
        builder.buildSkin();
        return builder.getAngle();
    }
}
