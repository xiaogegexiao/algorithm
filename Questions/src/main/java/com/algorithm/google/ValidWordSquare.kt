package com.algorithm.google

import com.algorithm.AlgorithmQuestion

class ValidWordSquare : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "888. Valid Word Square\n" +
                "Given a sequence of words, check whether it forms a valid word square.\n" +
                "\n" +
                "A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).\n" +
                "\n" +
                "Example\n" +
                "Given\n" +
                "[\n" +
                "  \"abcd\",\n" +
                "  \"bnrt\",\n" +
                "  \"crmy\",\n" +
                "  \"dtye\"\n" +
                "]\n" +
                "return true\n" +
                "\n" +
                "Explanation:\n" +
                "The first row and first column both read \"abcd\".\n" +
                "The second row and second column both read \"bnrt\".\n" +
                "The third row and third column both read \"crmy\".\n" +
                "The fourth row and fourth column both read \"dtye\".\n" +
                "\n" +
                "Therefore, it is a valid word square.\n" +
                "Given\n" +
                "[\n" +
                "  \"abcd\",\n" +
                "  \"bnrt\",\n" +
                "  \"crm\",\n" +
                "  \"dt\"\n" +
                "]\n" +
                "return true\n" +
                "\n" +
                "Explanation:\n" +
                "The first row and first column both read \"abcd\".\n" +
                "The second row and second column both read \"bnrt\".\n" +
                "The third row and third column both read \"crm\".\n" +
                "The fourth row and fourth column both read \"dt\".\n" +
                "\n" +
                "Therefore, it is a valid word square.\n" +
                "Given\n" +
                "[\n" +
                "  \"ball\",\n" +
                "  \"area\",\n" +
                "  \"read\",\n" +
                "  \"lady\"\n" +
                "]\n" +
                "return false\n" +
                "\n" +
                "Explanation:\n" +
                "The third row reads \"read\" while the third column reads \"lead\".\n" +
                "\n" +
                "Therefore, it is NOT a valid word square.")
    }

    /**
     * @param words: a list of string
     * @return: a boolean
     */
    fun validWordSquare(words: Array<String>): Boolean {
        val h = words.size
        for (i in 0 until h) {
            if (!checkCoord(i, h, words)) {
                return false
            }
        }

        return true
    }

    private fun checkCoord(x: Int, size: Int, words: Array<String>): Boolean {
        for (i in 0 until size) {
            return if (words[i].length <= x && words[x].length <= i) {
                continue
            } else if (words[i].length > x && words[x].length > i && words[i][x] == words[x][i]) {
                continue
            } else {
                false
            }
        }

        return true
    }
}