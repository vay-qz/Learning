package com.vay.cglibProxy;

import com.vay.Hello.HelloWithoutInterface;
import com.vay.Proxy.CGlibProxy;
import org.junit.jupiter.api.Test;

public class CGlibProxyTest {

    @Test
    public void test() {
        CGlibProxy cglib = new CGlibProxy();
        HelloWithoutInterface helloClass = new HelloWithoutInterface();
        HelloWithoutInterface cc = (HelloWithoutInterface) cglib.getInstance(helloClass);
        cc.say();
    }
}
