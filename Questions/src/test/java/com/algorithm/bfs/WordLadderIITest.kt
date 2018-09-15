package com.algorithm.bfs

import org.junit.Assert
import org.junit.Test

class WordLadderIITest {
    @Test
    fun test() {
        val wordLadderII = WordLadderII()
        wordLadderII.printDescription()
        Assert.assertEquals(listOf(
                listOf("hit", "hot", "dot", "dog", "cog"),
                listOf("hit", "hot", "lot", "log", "cog")
        ), wordLadderII.findLadders("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))

        Assert.assertEquals(emptyList<List<String>>(), wordLadderII.findLadders("hit", "cog", listOf("hot","dot","dog","lot","log")))
    }
}