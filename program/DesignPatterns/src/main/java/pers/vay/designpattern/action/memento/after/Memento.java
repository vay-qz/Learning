package pers.vay.designpattern.action.memento.after;

import lombok.Data;

@Data
public class Memento {
    private int x;
    private int y;

    Memento(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
