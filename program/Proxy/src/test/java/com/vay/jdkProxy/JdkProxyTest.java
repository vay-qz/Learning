package com.vay.jdkProxy;

import com.vay.Hello.HelloInterface;
import com.vay.Hello.HelloInterfaceImpl;
import com.vay.Proxy.JdkProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    @Test
    public void test() {
        HelloInterface a = new HelloInterfaceImpl();
        JdkProxy p = new JdkProxy(a);
        HelloInterface proxy = (HelloInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), a.getClass().getInterfaces(), p);
        proxy.say();
    }
}
