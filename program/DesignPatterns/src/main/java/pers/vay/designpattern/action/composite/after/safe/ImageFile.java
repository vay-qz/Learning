package pers.vay.designpattern.action.composite.after.safe;

public class ImageFile implements Component {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this);
    }

}
