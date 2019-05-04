package pers.vay.classloader;

import pers.vay.classloader.bean.Person;
import pers.vay.classloader.classloader.MyClassLoader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClassLoaderTest {

    private MyClassLoader myClassLoader = new MyClassLoader();
    private File file = new File("D:/Person.class");

    @Test
    void findClass() {
        Class<?> myClass = null;
        Object myObj = null;
        Method myMethod = null;
        try {
            myClass = Class.forName("com.vay.classloader.Person", true, myClassLoader);
            myObj = myClass.newInstance();
            myMethod = myClass.getMethod("getName");
            System.out.println(myMethod.invoke(myObj));
        } catch (IllegalAccessException|InstantiationException e) {
            System.out.println("获取实例失败");
        }  catch (ClassNotFoundException e) {
            System.out.println("未能成功加载");
        }catch (NoSuchMethodException e) {
            System.out.println("获取方法失败");
        } catch (InvocationTargetException e) {
            System.out.println("执行方法失败");
        }
        System.out.println(myObj.getClass().getClassLoader());

        Person person = new Person();

        System.out.println(person.getClass().getClassLoader());
    }

    @Test
    void getInputStream() {
        System.out.println(myClassLoader.getInputStream(file));
    }

    @Test
    void toByteArray() {
        System.out.println(myClassLoader.toByteArray(myClassLoader.getInputStream(file)));;
    }
}