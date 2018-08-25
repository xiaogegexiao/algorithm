package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashSet


class ValidSudoku : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:\n" +
                "\n" +
                "Each row must contain the digits 1-9 without repetition.\n" +
                "Each column must contain the digits 1-9 without repetition.\n" +
                "Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.\n" +
                "\n" +
                "A partially filled sudoku which is valid.\n" +
                "\n" +
                "The Sudoku board could be partially filled, where empty cells are filled with the character '.'.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]\n" +
                "Output: false\n" +
                "Explanation: Same as Example 1, except with the 5 in the top left corner being \n" +
                "    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.\n" +
                "Note:\n" +
                "\n" +
                "A Sudoku board (partially filled) could be valid but is not necessarily solvable.\n" +
                "Only the filled cells need to be validated according to the mentioned rules.\n" +
                "The given board contain only digits 1-9 and the character '.'.\n" +
                "The given board size is always 9x9.\n")
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val horiz = arrayOfNulls<MutableSet<Int>>(9)
        val vert = arrayOfNulls<MutableSet<Int>>(9)
        val grid = arrayOfNulls<MutableSet<Int>>(9)

        for (i in 0..8) {
            for (j in 0..8) {
                if (horiz[i] == null) {
                    horiz[i] = HashSet<Int>()
                }
                if (vert[j] == null) {
                    vert[j] = HashSet<Int>()
                }

                val gridIndex = i / 3 * 3 + j / 3
                if (grid[gridIndex] == null) {
                    grid[gridIndex] = HashSet<Int>()
                }
                val c = board[i][j]
                if (c == '.') {
                    continue
                }
                val num = c - '0'
                if (horiz[i]!!.contains(num)) {
                    return false
                }

                if (vert[j]!!.contains(num)) {
                    return false
                }

                if (grid[gridIndex]!!.contains(num)) {
                    return false
                }
                horiz[i]!!.add(num)
                vert[j]!!.add(num)
                grid[gridIndex]!!.add(num)
            }
        }
        return true
    }
}