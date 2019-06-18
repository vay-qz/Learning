package pers.vay.designpattern.create.builder;

import lombok.Setter;

/**
 * @author qiaozhe
 */
@Setter
public class Angle {

    private String face;
    private String body;
    private String skin;
    private String wing;

    public void show() {
        System.out.println("This is a beauty with " + this.face + " face and " +
                this.body + " body and " +
                this.skin + " skin and " +
                this.wing + " wing");
    }
}
