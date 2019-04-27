package designPattern.create.singleton.lazy;

/**
 * 懒汉式
 * 第一次使用时加载
 * 利用JVM保证线程安全（JVM可以保证类加载时是线程安全的）
 */
public class InnerClassSingleton {

    private static InnerClassSingleton INSTANCE;

    private InnerClassSingleton() {}

    public static InnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
    /**
     * 内部类中保持实例
     */
    private static class SingletonInstance {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
