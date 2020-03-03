package pers.vay.jzoffer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EasyTest {

    Easy easy = new Easy();

    @Test
    void findNumberIn2DArray() {
        int[][] t = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        assertEquals(easy.findNumberIn2DArray(t, 5), true);
        assertEquals(easy.findNumberIn2DArray(t, 20), false);
        int[][] tt = {{}};
        assertEquals(easy.findNumberIn2DArray(tt, 1), false);
        int[][] ttt = {{-5}};
        assertEquals(easy.findNumberIn2DArray(ttt, -2), false);
        int[][] tttt = {{-1, 3}};
        assertEquals(easy.findNumberIn2DArray(tttt, 3), true);

    }
}
