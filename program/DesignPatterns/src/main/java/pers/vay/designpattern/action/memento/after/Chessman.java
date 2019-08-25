package pers.vay.designpattern.action.memento.after;

import lombok.Data;

@Data
public class Chessman {
    private int x;
    private int y;
    private String name;

    public void move (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Memento save() {
        return new Memento(this.x, this.y);
    }

    public void repent(Memento memento) {
        this.x = memento.getX();
        this.y = memento.getY();
    }

}
