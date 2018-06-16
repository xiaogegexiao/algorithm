package com.algorithm.google

import com.algorithm.AlgorithmQuestion

class AddStrings : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.\n" +
                "\n" +
                "Example\n" +
                "Given num1 = \"123\", num2 = \"45\"\n" +
                "return \"168\"")
    }

    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    fun addStrings(num1: String?, num2: String?): String? {
        if (num1.isNullOrEmpty()) {
            return num2
        }
        if (num2.isNullOrEmpty()) {
            return num1
        }

        val len1 = num1!!.length
        val len2 = num2!!.length
        var overflow = 0
        val sb = StringBuilder()

        var i = 0
        while (i < len1 && i < len2) {
            val i1 = num1[len1 - i - 1] - '0'
            val i2 = num2[len2 - i - 1] - '0'
            sb.insert(0, ((i1 + i2 + overflow) % 10 + '0'.toInt()).toChar())
            overflow = (i1 + i2 + overflow) / 10
            i++
        }

        while (i < len1) {
            val i1 = num1[len1 - i - 1] - '0'
            sb.insert(0, ((i1 + overflow) % 10 + '0'.toInt()).toChar())
            overflow = (i1 + overflow) / 10
            i++
        }

        while (i < len2) {
            val i2 = num2[len2 - i - 1] - '0'
            sb.insert(0, ((i2 + overflow) % 10 + '0'.toInt()).toChar())
            overflow = (i2 + overflow) / 10
            i++
        }
        if (overflow > 0) {
            sb.insert(0, (overflow % 10 + '0'.toInt()).toChar())
        }
        return sb.toString()
    }
}