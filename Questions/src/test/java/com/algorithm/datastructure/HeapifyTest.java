package com.algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapifyTest {
    @Test
    public void test() {
        Heapify heapify = new Heapify();
        heapify.printDescription();

        int[] A = new int[]{3,2,1,4,5};
        heapify.heapify(A);
        assertArrayEquals(A, new int[]{1,2,3,4,5});
    }
}
