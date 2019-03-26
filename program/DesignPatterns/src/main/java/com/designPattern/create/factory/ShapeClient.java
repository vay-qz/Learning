package com.designPattern.create.factory;

public class ShapeClient {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("circle");
        shape.show();

        System.out.println(calK(2000,25));
//        int[] a = {2,1,7,2,5};
//        System.out.println(longestMountain(a));
    }

    public static int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {//[2,1,4,7,3,2,5]
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i])
                up = down = 0;
            if (A[i - 1] < A[i])
                up++;
            if (A[i - 1] > A[i])
                down++;
            if (up > 0 && down > 0 && up + down + 1 > res)
                res = up + down + 1;
        }
        return res;
    }

    public static int calK(int n, int k) {
        if (k > n) {
            return 0;
        }
        int target = 1;
        for (int i = 2; i <= k; i++) {
            target = next(target, n);
        }
        return target;
    }

    private static int next(int start, int n) {
        if (start == n) {
            return start / 10 + 1;
        }

        if (start > 10 && start % 10 == 9) {
            return after9(start,n);
        }

        int tmp = start * 10;
        if (tmp <= n) {
            return tmp;
        }

        return start + 1;
    }

    private static int after9(int m, int n) {
        int tmp = m * 10;
        if (tmp <= n) {
            return tmp;
        }

        tmp = m + 1;
        tmp /= 10;
        while (tmp % 10 == 0) {
            tmp /= 10;
        }

        if (tmp < 10) {
            return tmp;
        }
        return (m + 1) / 10;
    }

}
