package pers.vay.designpattern.action.composite.after;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private List<Component> files = new ArrayList<>();

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(ImageFile imageFile) {
        files.add(imageFile);
    }

}
