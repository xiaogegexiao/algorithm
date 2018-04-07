package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UniquePathsTest {
    @Test
    public void test() {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.printDescription();
        assertEquals(35, uniquePaths.uniquePaths(4, 5));
        assertEquals(6 , uniquePaths.uniquePaths(3, 3));
    }
}
