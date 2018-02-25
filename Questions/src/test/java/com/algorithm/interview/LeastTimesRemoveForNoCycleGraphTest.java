package com.algorithm.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeastTimesRemoveForNoCycleGraphTest {
    @Test
    public void test() {
        LeastTimesRemoveForNoCycleGraph leastTimesRemoveForNoCycleGraph = new LeastTimesRemoveForNoCycleGraph();
        leastTimesRemoveForNoCycleGraph.printDescription();
        int n = 5;
        List<LeastTimesRemoveForNoCycleGraph.Edge> list = new ArrayList<>();
        list.add(new LeastTimesRemoveForNoCycleGraph.Edge(4, 5));
        list.add(new LeastTimesRemoveForNoCycleGraph.Edge(1, 2));
        list.add(new LeastTimesRemoveForNoCycleGraph.Edge(1, 3));
        list.add(new LeastTimesRemoveForNoCycleGraph.Edge(3, 2));

        assertEquals(leastTimesRemoveForNoCycleGraph.leastEdgesToRemove(n, list), 2);
    }
}
