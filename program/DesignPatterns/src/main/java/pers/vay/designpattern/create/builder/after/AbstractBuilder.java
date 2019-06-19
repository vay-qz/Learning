package pers.vay.designpattern.create.builder.after;

import lombok.Getter;

/**
 * @author qiaozhe
 */
public abstract class AbstractBuilder {
    @Getter
    protected Angle angle = new Angle();

    public abstract void buildBody();

    public abstract void buildFace();

    public abstract void buildWing();

    public abstract void buildSkin();

}
