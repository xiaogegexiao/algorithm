package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashSet



class ReplaceWords : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.\n" +
                "\n" +
                "Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.\n" +
                "\n" +
                "You need to output the sentence after the replacement.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: dict = [\"cat\", \"bat\", \"rat\"]\n" +
                "sentence = \"the cattle was rattled by the battery\"\n" +
                "Output: \"the cat was rat by the bat\"\n" +
                "Note:\n" +
                "The input will only have lower-case letters.\n" +
                "1 <= dict words number <= 1000\n" +
                "1 <= sentence words number <= 1000\n" +
                "1 <= root length <= 100\n" +
                "1 <= sentence words length <= 1000\n")
    }

    fun replaceWords(dict: List<String>, sentence: String): String {
        val set = HashSet<String>()
        for (word in dict) {
            set.add(word)
        }

        val words = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val sb = StringBuilder()
        for (word in words) {
            var temp = word
            for (dWord in set) {
                if (dWord.length < temp.length && word.startsWith(dWord)) {
                    temp = dWord
                }
            }
            sb.append(temp).append(" ")
        }
        sb.deleteCharAt(sb.length - 1)
        return sb.toString()
    }
}