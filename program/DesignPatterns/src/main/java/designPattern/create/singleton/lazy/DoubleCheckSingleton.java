package designPattern.create.singleton.lazy;

/**
 * 懒汉式
 * 第一次使用时加载
 * 双重检查保证线程安全
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton INSTANCE;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if(INSTANCE == null){
            synchronized(DoubleCheckSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}