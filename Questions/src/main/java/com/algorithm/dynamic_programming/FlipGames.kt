package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class FlipGames : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive \"++\" into \"--\". The game ends when a person can no longer make a move and therefore the other person will be the winner.\n" +
                "\n" +
                "Write a function to compute all possible states of the string after one valid move.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given s = \"++++\", after one move, it may become one of the following states:\n" +
                "\n" +
                "[\n" +
                "  \"--++\",\n" +
                "  \"+--+\",\n" +
                "  \"++--\"\n" +
                "]\n" +
                "If there is no valid move, return an empty list [].")
    }

    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    fun generatePossibleNextMoves(s: String?): List<String> {
        val list = ArrayList<String>()

        if (s == null || s.length < 2) {
            return list
        }

        for (i in 0 until s.length - 1) {
            if (s[i] == '+' && s[i + 1] == '+') {
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length))
            }
        }
        return list
    }
}