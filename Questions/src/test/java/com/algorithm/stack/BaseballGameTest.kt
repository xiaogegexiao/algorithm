package com.algorithm.stack

import junit.framework.Assert.assertEquals
import org.junit.Test

class BaseballGameTest {
    @Test
    fun test() {
        val baseballGame = BaseballGame()
        baseballGame.printDescription()
        assertEquals(30, baseballGame.calPoints(arrayOf("5", "2", "C", "D", "+")))
        assertEquals(27, baseballGame.calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")))
    }
}