package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RangeSumQueryTest {
    @Test
    public void test() {
        RangeSumQuery rangeSumQuery = new RangeSumQuery();
        rangeSumQuery.printDescription();
        RangeSumQuery.NumArray numArray = new RangeSumQuery.NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        assertEquals(numArray.sumRange(0, 2), 1);
        assertEquals(numArray.sumRange(2, 5), -1);
        assertEquals(numArray.sumRange(0, 5), -3);
    }
}
