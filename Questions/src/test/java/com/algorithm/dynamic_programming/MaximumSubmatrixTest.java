package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaximumSubmatrixTest {
    @Test
    public void test() {
        MaximumSubmatrix maximumSubmatrix = new MaximumSubmatrix();
        maximumSubmatrix.printDescription();

        int[][] testCase = new int[][]{
                {1, 3, -1},
                {2, 3, -2},
                {-1, -2, -3}
        };
        assertEquals(9, maximumSubmatrix.maxSubmatrix(testCase));
    }
}
