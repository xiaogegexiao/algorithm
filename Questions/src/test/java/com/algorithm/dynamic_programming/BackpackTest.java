package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BackpackTest {
    @Test
    public void test() {
        Backpack backpack = new Backpack();
        backpack.printDescription();
        assertEquals(10, backpack.backPack(11, new int[]{2, 3, 5, 7}));
    }
}
