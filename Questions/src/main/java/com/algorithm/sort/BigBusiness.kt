package com.algorithm.sort

import com.algorithm.AlgorithmQuestion
import java.util.Comparator
import java.util.Arrays



class BigBusiness: AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given two arrays a and b. a[i] stands for the royalties of the film i, b[i] represents the money that the movie i can sell, now we have principal k, find how much money can be earned in the end.(Each movie only needs to be bought once and can only be sold once.)\n" +
                "\n" +
                " Notice\n" +
                "All the input does not exceed 100000\n" +
                "The size of array does not exceed 10000.\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given a = [3,1,5], b = [4,3,100], k = 1，return 4.\n" +
                "\n" +
                "Explanation:\n" +
                "Buy the second video first, then sell it, buy the first video, sell it again, and finally the principal becomes 4.\n" +
                "Given a = [3,1,5], b = [4,3,100], k = 10，return 108。\n" +
                "\n" +
                "Explanation:\n" +
                "Buy all the videos, sell them, and finally the principal becomes 108.")
    }

    /**
     * @param a: The cost of the film
     * @param b: The price of the selling of the film
     * @param k: The principal
     * @return: The answer
     */
    fun bigBusiness(a: IntArray?, b: IntArray?, k: Int): Int {
        if (a == null || b == null || a.size != b.size) {
            return 0
        }

        val videos = arrayOfNulls<Video>(a.size)
        for (i in a.indices) {
            videos[i] = Video(a[i], b[i])
        }
        Arrays.sort<Video>(videos) { v1, v2 -> v1.royalty - v2.royalty }
        var result = k
        for (video in videos) {
            if (video == null || video.royalty > video.price) {
                continue
            }
            if (result >= video.royalty) {
                result += video.price - video.royalty
            } else {
                break
            }
        }
        return result
    }

    internal inner class Video(royalty: Int, price: Int) {
        var royalty = 0
        var price = 0

        init {
            this.royalty = royalty
            this.price = price
        }
    }
}