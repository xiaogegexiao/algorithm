package com.algorithm.interview;

import com.algorithm.AlgorithmQuestion;

import java.util.*;

public class LeastTimesRemoveForNoCycleGraph implements AlgorithmQuestion {

    @Override
    public void printDescription() {
        System.out.println("Let G = (V, E) be an undirected graph on the nodes V = {1, ..., n}. Suppose the edges of the graph are removed one by one in some order e1, ..., em.\n" +
                " After the removal of some edge ei the graph will have no cycles remaining. Assume the e1, ... em edges \n" +
                "are given  as an Array A[1, ..., m], where A[i] contains the tuple of vertices ei = (u, v). Give an algorithm that, \n" +
                "when given as input n and the array A, outputs the smallest positive integer i such that the graph Gi = (V, E - {e1, ..., ei-1}) has no cycles. \n" +
                "(Define G1 = G.) The running time of your algorithm must be asymptotically better than O(mn).\n" +
                " Give pseudocode for your algorithm, analyze its running time, and prove it is correct");
    }

    public int leastEdgesToRemove(int n, List<Edge> edgeList) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (Edge edge : edgeList) {
            Set<Integer> set1 = map.getOrDefault(edge.v1, new HashSet<>());
            Set<Integer> set2 = map.getOrDefault(edge.v2, new HashSet<>());
            set1.add(edge.v2);
            set2.add(edge.v1);
            map.put(edge.v1, set1);
            map.put(edge.v2, set2);
        }

        int step = 0;
        for (int i = 0; i <= edgeList.size(); i++) {
            if (i > 0) {
                Edge removeEdge = edgeList.get(i - 1);
                map.get(removeEdge.v1).remove(removeEdge.v2);
                map.get(removeEdge.v2).remove(removeEdge.v1);
                System.out.println("removing edge " + removeEdge.v1 + ", " + removeEdge.v2);
            }
            if (!hasCycle(n, cloneMap(map))) {
                step = i;
                break;
            }
        }
        return step;
    }

    Map<Integer, Set<Integer>> cloneMap(Map<Integer, Set<Integer>> map) {
        Map<Integer, Set<Integer>> temp = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            temp.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        return temp;
    }

    boolean hasCycle(int n, Map<Integer, Set<Integer>> map) {

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                set.add(i);
            } else {
                if (!bfs(i, set, map)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean bfs(int i, Set<Integer> set, Map<Integer, Set<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        set.add(i);
        queue.offer(i);
        while (!queue.isEmpty()) {
            int source = queue.poll();
            Set<Integer> neighbors = map.get(source);
            for (Integer neighbor : neighbors) {
                map.get(neighbor).remove(source);
                if (set.contains(neighbor)) {
                    return false;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
            neighbors.clear();
        }
        return true;
    }

    static class Edge {
        int v1;
        int v2;
        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
