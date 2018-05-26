package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class LongestWordInDictionaryThroughDeleting : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.\n" +
                "\n" +
                "Example 1:\n" +
                "Input:\n" +
                "s = \"abpcplea\", d = [\"ale\",\"apple\",\"monkey\",\"plea\"]\n" +
                "\n" +
                "Output: \n" +
                "\"apple\"\n" +
                "Example 2:\n" +
                "Input:\n" +
                "s = \"abpcplea\", d = [\"a\",\"b\",\"c\"]\n" +
                "\n" +
                "Output: \n" +
                "\"a\"\n" +
                "Note:\n" +
                "All the strings in the input will only contain lower-case letters.\n" +
                "The size of the dictionary won't exceed 1,000.\n" +
                "The length of all the strings in the input won't exceed 1,000.")
    }

    fun findLongestWord(s: String?, d: List<String>?): String? {
        if (s == null || d == null) {
            return null
        }
        val chars = s.toCharArray()

        var longest = 0
        var result = ""
        for (w in d) {
            val wChars = w.toCharArray()
            if (wChars.size > longest && canForm(chars, wChars)) {
                longest = wChars.size
                result = w
            } else if (wChars.size == longest && canForm(chars, wChars)) {
                if (w.compareTo(result) < 0) {
                    result = w
                }
            }
        }
        return result
    }

    private fun canForm(newS: CharArray, word: CharArray): Boolean {
        var iS = 0
        var iW = 0
        while (iS < newS.size && iW < word.size) {
            if (newS[iS] == word[iW]) {
                iS++
                iW++
            } else {
                iS++
            }
        }
        return iW == word.size
    }
}