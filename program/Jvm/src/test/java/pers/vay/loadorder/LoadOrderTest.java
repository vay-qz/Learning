package pers.vay.loadorder;

import org.junit.jupiter.api.Test;
import pers.vay.classloader.loadorder.Child;
import pers.vay.classloader.loadorder.Parents;

public class LoadOrderTest {

    @Test
    public void loadOrder() {
        /**
         * 顺序
         * 1. 调用<clint>方法，<clint>方法由static静态代码块和类变量组成，执行顺序为代码先后顺序
         * 2. 为成员变量赋值
         * 3. 调用构造器
         */
        Parents parents = new Parents();
        System.out.println("父类静态变量：" + Parents.parentsStatic);
        System.out.println("父类成员变量param：" + parents.getParam());

        /**
         * 顺序
         * 1. 父类未初始化则先初始化父类，执行父类的<clint>方法
         * 2. 执行子类<clint>方法
         * 3. 为父类成员变量赋值并调用父类构造器
         * 4. 为子类成员变量赋值并调用子类构造器
         */
        Child child = new Child();
        System.out.println("父类静态变量：" + child.parentsStatic);
        System.out.println("父类成员变量param：" + child.getParam());
        System.out.println("子类成员变量childParam：" + child.getParam());
    }
}
