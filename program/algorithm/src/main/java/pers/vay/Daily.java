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

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] < prices[i - 1] ? dp[i - 1] : prices[i - 1];
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - dp[i]) > max) {
                max = prices[i] - dp[i];
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        return 1;
    }

    /**
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     *
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, zcxc(str1.length(), str2.length()));
    }

    /**
     * 辗转相除
     * @param length
     * @param length1
     * @return
     */
    private int zcxc(int length, int length1) {
        return length1 == 0 ? length : zcxc(length1, length % length1);
    }

}
