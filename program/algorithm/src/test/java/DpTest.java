import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DpTest {

    Dp dp = new Dp();

    @Test
    void minPathSum() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int[][] grid1 = {{1}};
        int[][] grid2 = {{1,3,1}};
        assertEquals(dp.minPathSum(grid), 7);
        assertEquals(dp.minPathSum(grid1), 1);
        assertEquals(dp.minPathSum(grid2), 5);
    }

    @Test
    void rob() {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        assertEquals(dp.rob(nums1), 4);
        assertEquals(dp.rob(nums2), 12);
    }

    @Test
    void climbStairs() {
        assertEquals(dp.climbStairs(2), 2);
        assertEquals(dp.climbStairs(3), 3);
    }

}