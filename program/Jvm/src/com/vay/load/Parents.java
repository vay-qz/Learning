package com.vay.load;

public class Parents {
    static {
//        System.out.println("parent t:" + t);
        t = 2;
    }
    public static int t = 1;



    public Parents (){
        System.out.println("cons" + t);
    }

}
