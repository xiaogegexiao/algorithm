package com.algorithm.dynamic_programming

import org.junit.Test
import java.util.*

class FlipGamesTest {
    @Test
    fun test() {
        val flipGames = FlipGames()
        flipGames.printDescription()
        System.out.println(Arrays.toString(flipGames.generatePossibleNextMoves("++++").toTypedArray()))
    }
}