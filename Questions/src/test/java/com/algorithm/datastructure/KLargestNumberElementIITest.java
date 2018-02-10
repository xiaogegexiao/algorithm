package com.algorithm.datastructure;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KLargestNumberElementIITest {
    @Test
    public void test() {
        KLargestNumberElementII kLargestNumberElementII = new KLargestNumberElementII();
        kLargestNumberElementII.printDescription();
        assertEquals(kLargestNumberElementII.kthLargestElement2(new int[]{9, 3, 2, 4, 8}, 3), 4);
    }
}
