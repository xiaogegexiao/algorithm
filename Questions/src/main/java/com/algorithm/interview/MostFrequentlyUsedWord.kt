package com.algorithm.interview

import com.algorithm.AlgorithmQuestion

class MostFrequentlyUsedWord : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("")
    }

    fun mostFrequentlyUsedWord(literatureText: String, exclusiveWords: Array<String>): Set<String> {
        var set = HashSet<String>()
        for (str in exclusiveWords) {
            set.add(str.toLowerCase())
        }
        var lowerText = literatureText.toLowerCase().toCharArray()
        for (i in 0 until lowerText.size) {
            if (lowerText[i] in 'a'..'z') {
                continue
            } else {
                lowerText[i] = ' '
            }
        }

        var result = HashSet<String>()
        var stringList = String(lowerText).split(' ')
        var map = HashMap<String, Int>()
        var appearanceCount = 0
        for (str in stringList) {
            if (set.contains(str)) {
                continue
            }
            var apTime = map.getOrDefault(str, 0) + 1
            map[str] = apTime
            appearanceCount = Math.max(appearanceCount, apTime)
        }
        for (str in map.keys) {
            if (map[str] == appearanceCount) {
                result.add(str)
            }
        }
        return result
    }
}