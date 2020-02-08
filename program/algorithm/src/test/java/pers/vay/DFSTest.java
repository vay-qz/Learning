package pers.vay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    DFS dfs = new DFS();

    @Test
    void numIslands() {
        char[][] test1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        char[][] test2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        assertEquals(dfs.numIslands(test1), 1);
        assertEquals(dfs.numIslands(test2), 3);
    }


}