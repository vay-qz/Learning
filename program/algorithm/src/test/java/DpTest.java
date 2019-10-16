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
    void rob(int[] nums) {

    }

}