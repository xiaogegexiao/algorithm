package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class EncodeAndDecodeTinyUrl : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Note: This is a companion problem to the System Design problem: Design TinyURL.\n" +
                "TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.\n" +
                "\n" +
                "Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.\n" +
                "\n")
    }

    val TINY_URL_PREFIX = "http://tinyurl.com/"

    // Map<String, String> urlToCode = new HashMap<>();
    var codeToUrl: MutableMap<String, String> = HashMap()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val hashStr = hash(longUrl)
        // urlToCode.put(longUrl, hashStr);
        codeToUrl[hashStr] = longUrl
        // System.out.println("hashStr = " + hashStr);
        return TINY_URL_PREFIX + hashStr
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        val hashStr = shortUrl.substring(TINY_URL_PREFIX.length, shortUrl.length)
        return codeToUrl[hashStr]!!
    }

    private fun hash(url: String): String {
        var url = url
        val random = "HELLO"
        url += random
        val mod = 1000000007
        val base = 33
        var res = 0
        for (i in 0 until url.length) {
            res = (res * base + url[i].toInt()) % mod
        }
        return Integer.toHexString(res)
    }
}