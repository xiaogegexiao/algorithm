package com.algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashFunctionTest {
    @Test
    public void test() {
        HashFunction hashFunction = new HashFunction();
        hashFunction.printDescription();
        assertEquals(hashFunction.hashCode("abcd".toCharArray(), 100), 78);
    }
}
