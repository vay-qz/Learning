package pers.vay.designpattern.action.composite.after.safe;

public class TextFile implements Component  {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this);
    }

}
