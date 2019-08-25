package pers.vay.designpattern.action.memento.before;

import lombok.Data;

@Data
public class Chessman {
    private int lastx;
    private int lasty;
    private int x;
    private int y;
    private String name;

    public void move (int x, int y) {
        this.lastx = x;
        this.lasty = y;
        this.x = x;
        this.y = y;
    }

    public void repent() {
        this.x = this.lastx;
        this.y = this.lasty;
    }

    public static void main(String[] args) {
        Chessman chessman = new Chessman();
        chessman.repent();
    }

}
