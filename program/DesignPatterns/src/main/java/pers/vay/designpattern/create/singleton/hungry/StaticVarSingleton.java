package pers.vay.designpattern.create.singleton.hungry;

/**
 * 饿汉式
 * 单例的初始化交给类初始化时去完成，即执行<clinit>方法时，即给静态变量赋值时完成
 * 若静态变量被final修饰，则初始化工作交给类加载的准备工作阶段完成(非基本变量也是吗？)
 */
public class StaticVarSingleton {
    private final static StaticVarSingleton INSTANCE = new StaticVarSingleton();

    private StaticVarSingleton() {}

    public static StaticVarSingleton getInstance() {
        return INSTANCE;
    }
}
