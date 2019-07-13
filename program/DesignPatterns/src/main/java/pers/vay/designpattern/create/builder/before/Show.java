package pers.vay.designpattern.create.builder.before;

import pers.vay.designpattern.create.builder.before.Angle;

/**
 * @author qiaozhe
 */
public class Show {

    public void showRolesLook() {
        Angle angle = new Angle();
        angle.buildBody();
        angle.buildFace();
        angle.buildWing();
        angle.buildSkin();
        angle.show();
    }
}
