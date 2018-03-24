package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PalindromeSubstringsTest {
    @Test
    public void test() {
        PalindromeSubstrings palindromeSubstrings = new PalindromeSubstrings();
        palindromeSubstrings.printDescription();
        assertEquals(palindromeSubstrings.countSubstrings("aaa"), 6);
    }
}
