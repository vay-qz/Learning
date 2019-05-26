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
    void twoSumWithHashTest() {
        int[] nums = {-18, 12, -6, 0};
        List<List<Integer>> a = test.twoSumWithHash(nums, -6, 0);
        System.out.println(a);
    }

    @Test
    void nSumTest() {
        int[] nums2 = {-18, 12, -6, 0};
        List<List<Integer>> res2 = test.nSum(nums2, -6, 2);
        System.out.println(res2);
        int[] nums3 = {-2, 0, 2, 3, -3};
        List<List<Integer>> res3 = test.nSum(nums3, 0, 4);
        System.out.println(res3);
    }

    @Test
    void threeSum() {
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> res = test.threeSum(nums);
        System.out.println(res);
    }
}