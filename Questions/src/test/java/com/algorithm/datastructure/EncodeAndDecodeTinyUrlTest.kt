package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class EncodeAndDecodeTinyUrlTest {
    @Test
    fun test() {
        val encodeAndDecodeTinyUrl = EncodeAndDecodeTinyUrl()
        encodeAndDecodeTinyUrl.printDescription()

        val url = "https://leetcode.com/problems/design-tinyurl"
        assertEquals(url, encodeAndDecodeTinyUrl.decode(encodeAndDecodeTinyUrl.encode(url)))
    }
}