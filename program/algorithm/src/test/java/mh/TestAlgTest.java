package mh;

import org.junit.jupiter.api.Test;

import java.util.List;

class TestAlgTest {

    public static TestAlg test = new TestAlg();

    @Test
    void twoSum() {
        int[] nums = {-18,12,3,0};
        int[] a = test.twoSum(nums, -6);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    @Test
    void threeSum() {
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> res = test.threeSum(nums);
        System.out.println(res);
    }
}