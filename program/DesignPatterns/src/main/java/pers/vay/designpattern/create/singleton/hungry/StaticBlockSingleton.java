package pers.vay.designpattern.create.singleton.hungry;

/**
 * 饿汉式
 * 单例的初始化交给类初始化时去完成，即执行<clint>方法时，即给静态代码块完成
 */
public class StaticBlockSingleton {
    private final static StaticBlockSingleton INSTANCE;

    static {
        INSTANCE = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {}

    public static StaticBlockSingleton getInstance(){
        return INSTANCE;
    }
}
