package com.algorithm.twoPointers;

import org.junit.Test;

public class FourSumTest {
    @Test
    public void test() {
        FourSum fourSum = new FourSum();
        fourSum.printDescription();
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
