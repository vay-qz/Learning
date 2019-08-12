package pers.vay.designpattern.action.composite.after.safe;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private List<Component> files = new ArrayList<>();

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(Component file) {
        files.add(file);
    }

    public void removeFile(Component file) {
        files.remove(file);
    }

    public void show() {
        for(Component component : files) {
            System.out.println(component);
        }
    }

}
