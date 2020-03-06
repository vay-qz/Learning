package pers.vay;

import java.util.ArrayList;
import java.util.List;

public class Daily {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int base = 1;
        for (int i = 0; candies != 0; i++, base++) {
            if (i == num_people) {
                i = 0;
            }
            if (base > candies) {
                ans[i] += candies;
                candies = 0;
            } else {
                ans[i] += base;
                candies -= base;
            }
        }
        return ans;
    }

    public int[][] findContinuousSequence(int target) {
        int size = (target / 2) + 1;
        int[] dp = new int[size + 1];
        List<int[]> res = new ArrayList<>();
        for (int head = 1; head <= size; head++) {
            dp[head - 1] = 0;
            for (int j = head; j <= size; j++) {
                dp[j] = dp[j - 1] + j;
                if (dp[j] == target) {
                    res.add(convertArray(head, j));
                    break;
                }
                if (dp[j] > target) {
                    break;
                }
            }
        }
        return convertIntArray(res);
    }

    private int[] convertArray(int i, int j) {
        int size = j - i + 1;
        int[] res = new int[size];
        for (int p = 0; p < size; p++,i++) {
            res[p] = i;
        }
        return res;
    }

    private int[][] convertIntArray(List<int[]> res) {
        int[][] rr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }

}
