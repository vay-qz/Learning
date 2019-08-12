package pers.vay.designpattern.action.composite.after.open;

public interface Component {
    void show();
    void addFile(Component component);
    void removeFile(Component component);
}
