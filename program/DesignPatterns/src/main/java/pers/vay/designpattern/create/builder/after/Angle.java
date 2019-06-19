package pers.vay.designpattern.create.builder.after;

import lombok.Getter;
import lombok.Setter;

/**
 * 天使类
 */
@Setter
@Getter
public class Angle {
    private String body;
    private String face;
    private String wing;
    private String skin;

    public void show() {
        System.out.println("This is a beauty with " +
                this.face + " face and " +
                this.body + " body and " +
                this.skin + " skin and " +
                this.wing + " wing");
    }
}
