package pers.vay;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 引用测试
 */
public class Yy {

    /**
     * 引用测试
     */
    public void test1(List list) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list = list1;
    }

    public static void main(String[] args) {
        Yy yy = new Yy();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        yy.test1(list);
        System.out.println(list);

        yy.test2();
    }

    public void test2() {
        Map<TestMap, String> ha = new HashMap<>();
        TestMap testMap1 = new TestMap("a", "b");
        TestMap testMap2 = new TestMap("a", "b");
        ha.put(testMap1, "yes");
        System.out.println(ha.get(testMap2));
    }

    @Setter
    @Getter
    class TestMap {
        String a;
        String b;
        TestMap(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            TestMap testMap = (TestMap)obj;
            if (testMap.a.equals(this.a) && testMap.b.equals(this.b)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }
    }

}
