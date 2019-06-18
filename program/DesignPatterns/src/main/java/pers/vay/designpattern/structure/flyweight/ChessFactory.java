package pers.vay.designpattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFactory {

    private Map<String, Chess> chessPool = new HashMap<>();

    public Chess getChess(String color) {
        Chess res = chessPool.get(color);
        if(res == null) {
            res = new ConcreteChess(color);
            chessPool.put(color, res);
            return res;
        }
        return res;
    }
}
