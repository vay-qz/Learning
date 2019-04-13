package com.vay.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {
    private Object obj;

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib  before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("cglib  after");
        return null;
    }

    public Object getInstance(Object obj) {
        this.obj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
