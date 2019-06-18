package pers.vay.designpattern.create.builder;

/**
 * @author qiaozhe
 */
public class AngleBuilder extends AbstractBuilder {
    @Override
    public void buildFace() {
        this.angle.setFace("pretty");
    }

    @Override
    public void buildBody() {
        this.angle.setBody("slim");
    }

    @Override
    public void buildSkin() {
        this.angle.setSkin("white");
    }

    @Override
    public void buildWing() {
        this.angle.setWing("full");
    }
}
