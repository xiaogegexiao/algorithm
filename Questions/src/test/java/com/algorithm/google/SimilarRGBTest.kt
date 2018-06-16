package com.algorithm.google

import junit.framework.Assert.assertEquals
import org.junit.Test

class SimilarRGBTest {
    @Test
    fun test() {
        val similarRGB = SimilarRGB()
        similarRGB.printDescription()
        assertEquals("#11ee66", similarRGB.similarRGB("#09f166"))
    }
}