package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinimumPartitionTest {
    @Test
    public void test() {
        MinimumPartition minimumPartition = new MinimumPartition();
        minimumPartition.printDescription();
        assertEquals(1, minimumPartition.findMin(new int[]{1, 6, 11, 5}));
    }
}
