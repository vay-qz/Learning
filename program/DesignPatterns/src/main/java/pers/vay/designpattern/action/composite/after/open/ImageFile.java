package pers.vay.designpattern.action.composite.after.open;

public class ImageFile implements Component {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this);
    }

    @Override
    public void addFile(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeFile(Component component) {
        throw new UnsupportedOperationException();
    }

}
