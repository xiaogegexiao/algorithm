package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.Stack



class ValidateParentheses : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.\n" +
                "\n" +
                "An input string is valid if:\n" +
                "\n" +
                "Open brackets must be closed by the same type of brackets.\n" +
                "Open brackets must be closed in the correct order.\n" +
                "Note that an empty string is also considered valid.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: \"()\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \"()[]{}\"\n" +
                "Output: true\n" +
                "Example 3:\n" +
                "\n" +
                "Input: \"(]\"\n" +
                "Output: false\n" +
                "Example 4:\n" +
                "\n" +
                "Input: \"([)]\"\n" +
                "Output: false\n" +
                "Example 5:\n" +
                "\n" +
                "Input: \"{[]}\"\n" +
                "Output: true")
    }

    fun isValid(s: String?): Boolean {
        if (s.isNullOrEmpty()) {
            return true
        }

        val stack = Stack<Int>()
        var valid = true
        for (i in 0 until s!!.length) {
            val c = s[i]
            when (c) {
                '{', '[', '(' -> {
                    stack.push(c.toInt())
                }
                '}' -> {
                    if (!stack.isEmpty() && stack.peek() == '{'.toInt()) {
                        stack.pop()
                    } else {
                        valid = false
                    }
                }
                ']' -> {
                    if (!stack.isEmpty() && stack.peek() == '['.toInt()) {
                        stack.pop()
                    } else {
                        valid = false
                    }
                }
                ')' -> {
                    if (!stack.isEmpty() && stack.peek() == '('.toInt()) {
                        stack.pop()
                    } else {
                        valid = false
                    }
                }
            }
            if (!valid) {
                break
            }
        }
        return stack.isEmpty() && valid
    }
}