package designPattern.create.singleton.lazy;

/**
 * 懒汉式
 * 第一次使用时加载
 */
public class SimpleSingleton {
    private static SimpleSingleton INSTANCE;

    private SimpleSingleton() {}

    public static SimpleSingleton getInstance() {
        if(INSTANCE == null){
            INSTANCE = new SimpleSingleton();
        }
        return INSTANCE;
    }
}
