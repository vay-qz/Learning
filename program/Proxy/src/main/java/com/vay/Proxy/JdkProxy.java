package com.vay.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

    private Object obj;

    public JdkProxy(Object obj){
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdkproxy  before");
        Object res = method.invoke(obj, args);
        System.out.println("jdkproxy after");
        return res;
    }
}
