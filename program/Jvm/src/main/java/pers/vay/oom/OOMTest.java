package pers.vay.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OOMTest {

    /**
     * 测试字符串常量池溢出，简介验证字符串常量池的位置
     * <p>
     *     -Xms20m
     *     -Xmx20m
     *     -XX:PermSize=10m
     *     -XX:MaxPermSize=10m
     *     -XX:-UseGCOverheadLimit  //一定要加，否则报的就是GC ovenhead limit exceeded
     * </p>
     * <p>
     *     预期
     *      1.6永久代溢出
     *      1.7/1.8堆溢出
     * </p>
     * <p>
     *     结论：
     *      1.6中字符串常量池在永久代中
     *      1.7、1.8在堆中
     * </p>
     */
    public void stringPoolOOM() {
        List<String> list = new ArrayList<String>();
        int i = 10000;
        while(true){
            System.out.println(i);
            list.add(String.valueOf("String" + i++).intern());
        }
    }

    /**
     * 测试class信息溢出，间接测试方法区的实现方式是永久代还是元空间
     * <p>
     *     jdk1.6/1.7
     *      -XX:PermSize=10m
     *      -XX:MaxPermSize=10m
     *     jdk1.8
     *      -XX:MetaspaceSize=10m
     *      -XX:MaxMetaspaceSize=10m
     * </p>
     * <p>
     *     预期
     *      1.6/1.7实现方式为永久代
     *      1.8为元空间
     * </p>
     */
    public void classInfosOOM() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    public void stringPoolPlaceTest() {
        String a = new StringBuilder("vay").append("pers.vay.mh").toString();
        System.out.println(a == a.intern());
    }

    public static void main(String[] args) {
        OOMTest oomTest = new OOMTest();
//        oomTest.stringPoolOOM();

//        try{
//            oomTest.classInfosOOM();
//        }catch (OutOfMemoryError e){
//            System.out.println(e.getMessage());
//        }
        /**
         * 测试常量与静态变量在内存中的位置
         * <p>
         *     -Xms2m
         *     -Xmx2m
         *     -XX:PermSize=3m
         *     -XX:MaxPermSize=3m
         * </p>
         * <p>
         *     结论
         *      常量与静态变量，1.6中位于永久代，1.8中位于堆
         * </p>
         */
        VarOOM test = new VarOOM();
        ConstOOM test2 = new ConstOOM();
        while(true){

        }

//        oomTest.stringPoolPlaceTest();
    }
}
