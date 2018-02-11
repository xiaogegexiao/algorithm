package com.algorithm.interview;

import org.junit.Test;

public class LastNumberTest {
    @Test
    public void test() {
        LastNumber lastNumber = new LastNumber();
        lastNumber.printDescription();
        System.out.println(lastNumber.getLastIndex(4));
    }
}
