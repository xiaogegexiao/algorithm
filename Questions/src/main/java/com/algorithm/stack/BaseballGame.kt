package com.algorithm.stack

import com.algorithm.AlgorithmQuestion
import java.util.Stack



class BaseballGame : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("You're now a baseball game point recorder.\n" +
                "\n" +
                "Given a list of strings, each string can be one of the 4 following types:\n" +
                "\n" +
                "Integer (one round's score): Directly represents the number of points you get in this round.\n" +
                "\"+\" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.\n" +
                "\"D\" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.\n" +
                "\"C\" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.\n" +
                "Each round's operation is permanent and could have an impact on the round before and the round after.\n" +
                "\n" +
                "You need to return the sum of the points you could get in all the rounds.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: [\"5\",\"2\",\"C\",\"D\",\"+\"]\n" +
                "Output: 30\n" +
                "Explanation: \n" +
                "Round 1: You could get 5 points. The sum is: 5.\n" +
                "Round 2: You could get 2 points. The sum is: 7.\n" +
                "Operation 1: The round 2's data was invalid. The sum is: 5.  \n" +
                "Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.\n" +
                "Round 4: You could get 5 + 10 = 15 points. The sum is: 30.\n" +
                "Example 2:\n" +
                "Input: [\"5\",\"-2\",\"4\",\"C\",\"D\",\"9\",\"+\",\"+\"]\n" +
                "Output: 27\n" +
                "Explanation: \n" +
                "Round 1: You could get 5 points. The sum is: 5.\n" +
                "Round 2: You could get -2 points. The sum is: 3.\n" +
                "Round 3: You could get 4 points. The sum is: 7.\n" +
                "Operation 1: The round 3's data is invalid. The sum is: 3.  \n" +
                "Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.\n" +
                "Round 5: You could get 9 points. The sum is: 8.\n" +
                "Round 6: You could get -4 + 9 = 5 points. The sum is 13.\n" +
                "Round 7: You could get 9 + 5 = 14 points. The sum is 27.\n" +
                "Note:\n" +
                "The size of the input list will be between 1 and 1000.\n" +
                "Every integer represented in the list will be between -30000 and 30000.")
    }

    fun calPoints(ops: Array<String>?): Int {
        if (ops == null || ops.isEmpty()) {
            return 0
        }
        val stack = Stack<Int>()
        for (op in ops) {
            when (op) {
                "+" -> {
                    val last1 = stack.pop()
                    val last2 = stack.pop()
                    stack.push(last2)
                    stack.push(last1)
                    stack.push(last1 + last2)
                }

                "D" -> {
                    stack.push(stack.peek() * 2)
                }

                "C" -> {
                    stack.pop()
                }

                else -> {
                    stack.push(Integer.parseInt(op))
                }
            }
        }

        var res = 0
        while (!stack.isEmpty()) {
            res += stack.pop()
        }
        return res
    }
}