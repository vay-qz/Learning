package com.vay.main;

import com.vay.proxy.Hello;
import com.vay.proxy.HelloImpl;
import com.vay.proxy.ProxyClass;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Hello a = new HelloImpl();
        ProxyClass p = new ProxyClass(a);
        Hello proxy = (Hello)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), a.getClass().getInterfaces(), p);
        proxy.say();
    }
}
