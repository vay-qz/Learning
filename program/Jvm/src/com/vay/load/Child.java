package com.vay.load;

public class Child extends Parents {

    public static int p ;

    static {
        System.out.println("child" + "t:" + t + "p:" + p);
        p = t;
    }

    public Child() {
        System.out.println("child" + p);
    }
}
