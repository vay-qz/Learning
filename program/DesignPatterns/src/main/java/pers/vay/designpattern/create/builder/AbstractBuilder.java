package pers.vay.designpattern.create.builder;

/**
 * @author qiaozhe
 */
public abstract class AbstractBuilder {
    protected Angle angle = new Angle();
    public abstract void buildFace();

    public abstract  void buildBody();

    public abstract  void buildSkin();

    public abstract  void buildWing();

    public Angle getResult() {
        return angle;
    }

    public Angle construct() {
        buildBody();
        buildFace();
        buildSkin();
        buildWing();
        return getResult();
    }
}
