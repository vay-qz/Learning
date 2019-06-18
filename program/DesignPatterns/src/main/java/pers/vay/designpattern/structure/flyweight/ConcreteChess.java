package pers.vay.designpattern.structure.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConcreteChess implements Chess {

    private String color;

    public void show(String x, String y) {
        System.out.println(this.color + " X:" + x + "Y:" + y);
    }
}
