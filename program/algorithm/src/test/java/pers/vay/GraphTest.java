package pers.vay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    Graph graph = new Graph();

    @Test
    void findJudge() {
        int[][] arr = {{1,2},{2,3}};
        System.out.println(graph.findJudge(3, arr));
    }

    @Test
    void canFinish() {
        int[][] arr = {{1, 0}};
        assertEquals(true, graph.canFinish(2, arr));
        int[][] arr2 = {{1, 0}, {0, 1}};
        assertEquals(false, graph.canFinish(2, arr2));
        int[][] arr3 = {{0, 1}};
        assertEquals(true, graph.canFinish(2, arr3));
        assertEquals(true, graph.canFinish(3, arr));
        int[][] arr4 = {};
        assertEquals(true, graph.canFinish(3, arr4));
    }

    @Test
    void canFinish2() {
        int[][] arr = {{1, 0}};
        assertEquals(true, graph.canFinishDFS(2, arr));
        int[][] arr2 = {{1, 0}, {0, 1}};
        assertEquals(false, graph.canFinishDFS(2, arr2));
        int[][] arr3 = {{0, 1}};
        assertEquals(true, graph.canFinishDFS(2, arr3));
        assertEquals(true, graph.canFinishDFS(3, arr));
        int[][] arr4 = {};
        assertEquals(true, graph.canFinishDFS(3, arr4));
    }
}