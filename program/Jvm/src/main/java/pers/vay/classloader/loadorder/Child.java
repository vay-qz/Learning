package pers.vay.classloader.loadorder;

public class Child extends Parents {

    static {
        parentsStatic = "子类静态代码块";
    }

    private String childParam = "子类成员变量";

    public Child() {
        this.setParam("子类构造器");
        this.setChildParam("子类构造器");
    }

    public String getChildParam() {
        return childParam;
    }

    public void setChildParam(String childParam) {
        this.childParam = childParam;
    }
}
