package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.LinkedList
import java.util.Queue



class MineSweeper : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Let's play the minesweeper game (Wikipedia, online game)!\n" +
                "\n" +
                "You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.\n" +
                "\n" +
                "Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:\n" +
                "\n" +
                "If a mine ('M') is revealed, then the game is over - change it to 'X'.\n" +
                "If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.\n" +
                "If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.\n" +
                "Return the board when no more squares will be revealed.\n" +
                "Example 1:\n" +
                "Input: \n" +
                "\n" +
                "[['E', 'E', 'E', 'E', 'E'],\n" +
                " ['E', 'E', 'M', 'E', 'E'],\n" +
                " ['E', 'E', 'E', 'E', 'E'],\n" +
                " ['E', 'E', 'E', 'E', 'E']]\n" +
                "\n" +
                "Click : [3,0]\n" +
                "\n" +
                "Output: \n" +
                "\n" +
                "[['B', '1', 'E', '1', 'B'],\n" +
                " ['B', '1', 'M', '1', 'B'],\n" +
                " ['B', '1', '1', '1', 'B'],\n" +
                " ['B', 'B', 'B', 'B', 'B']]\n" +
                "\n" +
                "Explanation:\n" +
                "\n" +
                "Example 2:\n" +
                "Input: \n" +
                "\n" +
                "[['B', '1', 'E', '1', 'B'],\n" +
                " ['B', '1', 'M', '1', 'B'],\n" +
                " ['B', '1', '1', '1', 'B'],\n" +
                " ['B', 'B', 'B', 'B', 'B']]\n" +
                "\n" +
                "Click : [1,2]\n" +
                "\n" +
                "Output: \n" +
                "\n" +
                "[['B', '1', 'E', '1', 'B'],\n" +
                " ['B', '1', 'X', '1', 'B'],\n" +
                " ['B', '1', '1', '1', 'B'],\n" +
                " ['B', 'B', 'B', 'B', 'B']]\n" +
                "\n" +
                "Explanation:\n" +
                "\n" +
                "Note:\n" +
                "The range of the input matrix's height and width is [1,50].\n" +
                "The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.\n" +
                "The input board won't be a stage when game is over (some mines have been revealed).\n" +
                "For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.\n")
    }

    var xDelta = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)
    var yDelta = intArrayOf(0, 0, 1, -1, 1, -1, -1, 1)

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X'
            return board
        }
        val queue = LinkedList<IntArray>()
        queue.offer(click)
        while (!queue.isEmpty()) {
            val position = queue.poll()
            val c = board[position!![0]][position[1]]
            if (c != 'E') {
                continue
            }

            val count = calcMine(position[0], position[1], board)
            if (count == 0) {
                board[position[0]][position[1]] = 'B'
            } else {
                board[position[0]][position[1]] = ('0'.toInt() + count).toChar()
                continue
            }
            for (i in xDelta.indices) {
                val newX = position[0] + xDelta[i]
                val newY = position[1] + yDelta[i]
                if (!valid(newX, newY, board)) {
                    continue
                }
                if (board[newX][newY] == 'E') {
                    queue.offer(intArrayOf(newX, newY))
                }
            }
        }

        return board
    }

    fun valid(x: Int, y: Int, board: Array<CharArray>): Boolean {
        return x >= 0 && x < board.size && y >= 0 && y < board[0].size
    }

    fun calcMine(x: Int, y: Int, board: Array<CharArray>): Int {
        var count = 0
        for (j in xDelta.indices) {
            val newX = x + xDelta[j]
            val newY = y + yDelta[j]
            if (valid(newX, newY, board) && board[newX][newY] == 'M') {
                count++
            }
        }
        return count
    }
}