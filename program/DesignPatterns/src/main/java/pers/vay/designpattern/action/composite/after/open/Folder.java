package pers.vay.designpattern.action.composite.after.open;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private List<Component> files = new ArrayList<>();

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void addFile(Component file) {
        files.add(file);
    }

    @Override
    public void removeFile(Component file) {
        files.remove(file);
    }

    @Override
    public void show() {
        for(Component component : files) {
            System.out.println(component);
        }
    }

}
