package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TriangleTest {
    @Test
    public void test() {
        Triangle triangle = new Triangle();
        triangle.printDescription();
        assertEquals(11, triangle.minimumTotal(new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}));
    }
}
