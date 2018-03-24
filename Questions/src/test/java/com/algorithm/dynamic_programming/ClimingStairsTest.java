package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ClimingStairsTest {
    @Test
    public void test() {
        ClimingStairs climingStairs = new ClimingStairs();
        climingStairs.printDescription();
        assertEquals(climingStairs.climbStairs(2), 2);
        assertEquals(climingStairs.climbStairs(3), 3);
    }
}
