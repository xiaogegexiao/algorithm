package com.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountBitsTest {
    @Test
    public void test() {
        CountBits countBits = new CountBits();
        countBits.printDescription();
        assertArrayEquals(countBits.countBits(5), new int[]{0,1,1,2,1,2});
    }
}
