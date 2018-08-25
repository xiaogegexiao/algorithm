package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList


class GenerateParenthese : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.\n" +
                "\n" +
                "For example, given n = 3, a solution set is:\n" +
                "\n" +
                "[\n" +
                "  \"((()))\",\n" +
                "  \"(()())\",\n" +
                "  \"(())()\",\n" +
                "  \"()(())\",\n" +
                "  \"()()()\"\n" +
                "]")
    }

    fun generateParenthesis(n: Int): List<String> {
        val res = ArrayList<String>()
        dfs(res, n, n, StringBuilder())
        return res
    }

    private fun dfs(res: MutableList<String>, open: Int, close: Int, sb: StringBuilder) {
        if (open == 0 && close == 0) {
            res.add(sb.toString())
            return
        }
        if (open > 0) {
            sb.append('(')
            dfs(res, open - 1, close, sb)
            sb.deleteCharAt(sb.length - 1)
        }
        if (open < close) {
            sb.append(')')
            dfs(res, open, close - 1, sb)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}