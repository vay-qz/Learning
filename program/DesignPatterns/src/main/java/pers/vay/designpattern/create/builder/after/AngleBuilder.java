package pers.vay.designpattern.create.builder.after;

/**
 * @author qiaozhe
 */
public class AngleBuilder extends AbstractBuilder{

    @Override
    public void buildBody() {
        angle.setBody("pretty");
    }

    @Override
    public void buildFace() {
        angle.setFace("slim");
    }

    @Override
    public void buildWing() {
        angle.setWing("white");
    }

    @Override
    public void buildSkin() {
        angle.setSkin("full");
    }

}
