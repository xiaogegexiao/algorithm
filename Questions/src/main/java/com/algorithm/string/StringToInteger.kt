package com.algorithm.string

import com.algorithm.AlgorithmQuestion

class StringToInteger : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Implement atoi which converts a string to an integer.\n" +
                "\n" +
                "The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.\n" +
                "\n" +
                "The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.\n" +
                "\n" +
                "If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.\n" +
                "\n" +
                "If no valid conversion could be performed, a zero value is returned.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "Only the space character ' ' is considered as whitespace character.\n" +
                "Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.\n" +
                "Example 1:\n" +
                "\n" +
                "Input: \"42\"\n" +
                "Output: 42\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \"   -42\"\n" +
                "Output: -42\n" +
                "Explanation: The first non-whitespace character is '-', which is the minus sign.\n" +
                "             Then take as many numerical digits as possible, which gets 42.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: \"4193 with words\"\n" +
                "Output: 4193\n" +
                "Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.\n" +
                "Example 4:\n" +
                "\n" +
                "Input: \"words and 987\"\n" +
                "Output: 0\n" +
                "Explanation: The first non-whitespace character is 'w', which is not a numerical \n" +
                "             digit or a +/- sign. Therefore no valid conversion could be performed.\n" +
                "Example 5:\n" +
                "\n" +
                "Input: \"-91283472332\"\n" +
                "Output: -2147483648\n" +
                "Explanation: The number \"-91283472332\" is out of the range of a 32-bit signed integer.\n" +
                "             Thefore INT_MIN (−231) is returned.")
    }

    fun myAtoi(str: String?): Int {
        if (str == null || str.isEmpty()) {
            return 0
        }
        var index = 0
        while (index < str.length && str[index] == ' ') {
            index++
        }
        var positive = true
        if (index < str.length) {
            if (str[index] == '-') {
                index++
                positive = false
            } else if (str[index] == '+') {
                index++
                positive = true
            }
        }
        var res: Long = 0
        while (index < str.length) {
            val c = str[index]
            if (c in '0'..'9') {
                if (positive && res >= Integer.MAX_VALUE) {
                    res = Integer.MAX_VALUE.toLong()
                } else if (!positive && res >= -Integer.MIN_VALUE.toLong()) {
                    res = -Integer.MIN_VALUE.toLong()
                } else {
                    res *= 10
                    res += (c - '0').toLong()
                }
            } else {
                break
            }
            index++
        }
        if (positive && res >= Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE.toLong()
        } else if (!positive && res >= -Integer.MIN_VALUE.toLong()) {
            res = -Integer.MIN_VALUE.toLong()
        }
        // System.out.println("sign = " + positive + ", res = " + res);
        return (if (positive) res else -res).toInt()
    }
}