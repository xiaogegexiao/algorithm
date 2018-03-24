package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinCostClimingStairsTest {
    @Test
    public void test() {
        MinCostClimingStairs minCostClimingStairs = new MinCostClimingStairs();
        minCostClimingStairs.printDescription();
        assertEquals(minCostClimingStairs.minCostClimbingStairs(new int[]{10, 15, 20}), 15);
        assertEquals(minCostClimingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}), 6);
    }
}
