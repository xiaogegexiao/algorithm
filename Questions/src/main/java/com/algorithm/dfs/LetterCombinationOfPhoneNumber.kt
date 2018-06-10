package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.Arrays
import java.util.ArrayList



class LetterCombinationOfPhoneNumber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given a digit string excluded 01, return all possible letter combinations that the number could represent.\n" +
                "\n" +
                "A mapping of digit to letters (just like on the telephone buttons) is given below.\n" +
                "\n" +
                "Cellphone\n" +
                "\n" +
                "Example\n" +
                "Given \"23\"\n" +
                "\n" +
                "Return [\"ad\", \"ae\", \"af\", \"bd\", \"be\", \"bf\", \"cd\", \"ce\", \"cf\"]")
    }

    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */

    fun letterCombinations(digits: String): ArrayList<String> {

        val result = ArrayList<String>()
        if (digits.isNotEmpty()) {
            dfs(result, StringBuilder(), 0, digits)
        }

        return result
    }

    private fun dfs(result: MutableList<String>, cache: StringBuilder, index: Int, digits: String) {
        if (index == digits.length) {
            result.add(cache.toString())
            return
        }

        for (s in getLetters(digits[index] - '0' - 1)) {
            cache.append(s)
            dfs(result, cache, index + 1, digits)
            cache.deleteCharAt(index)
        }
    }

    private fun getLetters(i: Int): List<String> {
        return when (i) {
            0 -> ArrayList()
            1 -> ArrayList(Arrays.asList("a", "b", "c"))
            2 -> ArrayList(Arrays.asList("d", "e", "f"))
            3 -> ArrayList(Arrays.asList("g", "h", "i"))
            4 -> ArrayList(Arrays.asList("j", "k", "l"))
            5 -> ArrayList(Arrays.asList("m", "n", "o"))
            6 -> ArrayList(Arrays.asList("p", "q", "r", "s"))
            7 -> ArrayList(Arrays.asList("t", "u", "v"))
            else -> ArrayList(Arrays.asList("w", "x", "y", "z"))
        }
    }
}