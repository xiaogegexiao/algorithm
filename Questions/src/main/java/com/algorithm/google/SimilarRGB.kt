package com.algorithm.google

import com.algorithm.AlgorithmQuestion

class SimilarRGB : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "In the following, every capital letter represents some hexadecimal digit from 0 to f.\n" +
                "\n" +
                "The red-green-blue color \"#AABBCC\" can be written as \"#ABC\" in shorthand. For example, \"#15c\" is shorthand for the color \"#1155cc\".\n" +
                "\n" +
                "Now, say the similarity between two colors \"#ABCDEF\" and \"#UVWXYZ\" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.\n" +
                "\n" +
                "Given the color \"#ABCDEF\", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some \"#XYZ\")\n" +
                "\n" +
                "color is a string of length 7.\n" +
                "color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f\n" +
                "Any answer which has the same (highest) similarity as the best answer will be accepted.\n" +
                "All inputs and outputs should use lowercase letters, and the output is 7 characters.\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Input: color = \"#09f166\"\n" +
                "Output: \"#11ee66\"\n" +
                "Explanation:  \n" +
                "The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.\n" +
                "This is the highest among any shorthand color.")
    }

    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    fun similarRGB(color: String): String {
        val red = charToInt(color[1]) * 16 + charToInt(color[2])
        val green = charToInt(color[3]) * 16 + charToInt(color[4])
        val blue = charToInt(color[5]) * 16 + charToInt(color[6])

        var closeRed = red / 17
        if (red - closeRed * 17 > (closeRed + 1) * 17 - red) {
            closeRed++
        }

        var closeGreen = green / 17
        if (green - closeGreen * 17 > (closeGreen + 1) * 17 - green) {
            closeGreen++
        }

        var closeBlue = blue / 17
        if (blue - closeBlue * 17 > (closeBlue + 1) * 17 - blue) {
            closeBlue++
        }

        val sb = StringBuilder()
        sb.append('#')
        sb.append(intToChar(closeRed))
        sb.append(intToChar(closeRed))
        sb.append(intToChar(closeGreen))
        sb.append(intToChar(closeGreen))
        sb.append(intToChar(closeBlue))
        sb.append(intToChar(closeBlue))
        return sb.toString()

    }

    private fun charToInt(c: Char): Int {
        return if (c in '0'..'9') {
            c - '0'
        } else {
            c - 'a' + 10
        }
    }

    private fun intToChar(i: Int): Char {
        return if (i in 0..9) {
            (i + '0'.toInt()).toChar()
        } else {
            (i - 10 + 'a'.toInt()).toChar()
        }
    }
}