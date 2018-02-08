package com.algorithm.twoPointers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestNumberTest {
    @Test
    public void test() {
        KthSmallestNumber kthSmallestNumber = new KthSmallestNumber();
        kthSmallestNumber.printDescription();
        assertEquals(3, kthSmallestNumber.kthSmallest(3, new int[]{3,4,1,2,5}));
    }
}
