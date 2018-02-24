package com.algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TopKFrequentWordsTest {
    @Test
    public void test() {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        topKFrequentWords.printDescription();
        assertEquals(topKFrequentWords.topKFrequentWords(new String[]{
                "yes", "lint", "code",
                "yes", "code", "baby",
                "you", "baby", "chrome",
                "safari", "lint", "code",
                "body", "lint", "code"
        }, 4), new String[]{"code", "lint", "baby", "yes"});
    }
}
