package com.algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSeqTest {
    @Test
    public void test() {
        LongestConsecutiveSeq longestConsecutiveSeq = new LongestConsecutiveSeq();
        longestConsecutiveSeq.printDescription();

        assertEquals(longestConsecutiveSeq.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4);
    }
}
