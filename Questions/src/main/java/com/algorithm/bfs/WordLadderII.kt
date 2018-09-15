package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.*


class WordLadderII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:\n" +
                "\n" +
                "Only one letter can be changed at a time\n" +
                "Each transformed word must exist in the word list. Note that beginWord is not a transformed word.\n" +
                "Note:\n" +
                "\n" +
                "Return an empty list if there is no such transformation sequence.\n" +
                "All words have the same length.\n" +
                "All words contain only lowercase alphabetic characters.\n" +
                "You may assume no duplicates in the word list.\n" +
                "You may assume beginWord and endWord are non-empty and are not the same.\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "beginWord = \"hit\",\n" +
                "endWord = \"cog\",\n" +
                "wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]\n" +
                "\n" +
                "Output:\n" +
                "[\n" +
                "  [\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],\n" +
                "  [\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]\n" +
                "]\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "beginWord = \"hit\"\n" +
                "endWord = \"cog\"\n" +
                "wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]\n" +
                "\n" +
                "Output: []\n" +
                "\n" +
                "Explanation: The endWord \"cog\" is not in wordList, therefore no possible transformation.")
    }

    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val dict = HashSet<String>()
        for (word in wordList) {
            dict.add(word)
        }
        dict.add(beginWord)
        val distance = HashMap<String, Int>()
        val map = HashMap<String, MutableList<String>>()
        val usedWords = HashSet<String>()
        val queue = LinkedList<String>()
        queue.offer(beginWord)
        usedWords.add(beginWord)
        distance[beginWord] = 1
        var found = false
        var len = 1
        while (!queue.isEmpty() && !found) {
            val qSize = queue.size
            len++
            for (i in 0 until qSize) {
                val word = queue.poll()
                // System.out.println("try " + word);
                val nextWords = generateNextWords(word, dict, usedWords)
                for (nextWord in nextWords) {
                    val value = map.getOrDefault(nextWord, ArrayList())
                    value.add(word)
                    map[nextWord] = value
                    if (usedWords.contains(nextWord)) {
                        continue
                    }
                    distance[nextWord] = len
                    usedWords.add(nextWord)
                    queue.offer(nextWord)
                    // System.out.println("found " + nextWord + " len = " + len);
                    if (nextWord == endWord) {
                        found = true
                        break
                    }
                }
            }
        }
        println("len for begin to end is $len, found = $found")

        val res = ArrayList<List<String>>()
        if (found) {
            val list = ArrayList<String>()
            list.add(endWord)
            dfs(res, list, map, distance, len, 1, endWord, beginWord)
        }
        return res
    }

    fun dfs(res: MutableList<List<String>>, list: MutableList<String>, map: Map<String, List<String>>, distance: Map<String, Int>, totalLen: Int, curtLen: Int, word: String, beginWord: String) {
        var curtLen = curtLen
        if (totalLen == curtLen) {
            if (word == beginWord) {
                val newList = ArrayList(list)
                newList.reverse()
                res.add(newList)
            }
            return
        }

        val choices = (map as java.util.Map<String, List<String>>).getOrDefault(word, ArrayList())
        for (choice in choices) {
            // System.out.println("choice " + choice + " distance is " + distance.get(choice));
            // System.out.println("word " + word + " distance is " + distance.get(word));
            if (distance[choice]!! + 1 != distance[word]) {
                continue
            }
            list.add(choice)
            curtLen++
            dfs(res, list, map, distance, totalLen, curtLen, choice, beginWord)
            curtLen--
            list.removeAt(list.size - 1)
        }
    }

    fun generateNextWords(word: String?, dict: Set<String>, usedWords: Set<String>): List<String> {
        val res = ArrayList<String>()
        for (i in 0 until word!!.length) {
            var r = 'a'
            while (r <= 'z') {
                if (r == word[i]) {
                    r++
                    continue
                }
                val newWord = word.substring(0, i) + r + word.substring(i + 1, word.length)
                if (dict.contains(newWord)) {
                    res.add(newWord)
                }
                r++
            }
        }
        return res
    }
}