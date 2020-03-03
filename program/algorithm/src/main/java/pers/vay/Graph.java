package pers.vay;

import java.util.*;

public class Graph {

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for (int[] part : trust) {
            outDegree[part[0]]++;
            inDegree[part[1]]++;
        }
        for (int i = 1; i < N+1; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            inDegrees[prerequisite[0]]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            int inDegree = inDegrees[i];
            if (inDegree == 0) {
                list.add(i);
            }
        }
        while (!list.isEmpty()) {
            int i = list.removeFirst();
            for (int[] pre : prerequisites) {
                if (pre[1] == i) {
                    inDegrees[pre[0]]--;
                    if (inDegrees[pre[0]] == 0) {
                        list.add(pre[0]);
                    }
                }
            }
        }
        for (int i : inDegrees) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> t = new HashMap<>();
        Set<Integer> shouldJudge = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            t.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            t.get(prerequisite[1]).add(prerequisite[0]);
            shouldJudge.add(prerequisite[1]);
        }
        Set<Integer> visitFinish = new HashSet<>();
        for (int i : shouldJudge) {
            if (!dfs(i, t, new HashSet<Integer>(), visitFinish)) {
                return false;
            }
            visitFinish.add(i);
        }
        return true;
    }

    private boolean dfs(int start, Map<Integer, List<Integer>> t, HashSet<Integer> visit, Set<Integer> visitFinish) {
        if (!t.containsKey(start) || visitFinish.contains(start)) {
            return true;
        }
        if (visit.contains(start)) {
            return false;
        }
        visit.add(start);
        List<Integer> post = t.get(start);
        for (int i : post) {
            if (!dfs(i, t, visit, visitFinish)) {
                return false;
            }
        }
        visit.remove(start);
        return true;
    }

}
