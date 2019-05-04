package pers.vay.classloader.loadorder;

public class Parents {

    static {
        parentsStatic = "静态代码块赋值";
    }

    public static String parentsStatic = "原始值";

    private String param = "原始值";

    public Parents (){
        this.param = "构造器赋值";
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String str) {
        this.param = str;
    }
}
