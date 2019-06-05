package com.vay.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaozhe
 */
public class Main {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap();
        Person p1 = new Person("1");
        Person p2 = new Person("2");
        map.put(p1, "a");
        map.put(p2, "b");
        System.out.println(map);
    }
}
