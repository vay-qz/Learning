package pers.vay.designpattern.action.memento.after;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MementoCaretaker {
    private List<Memento> memento = new ArrayList<>();
}
