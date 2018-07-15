package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class BestTimeBuySellStockWithTransactionFeeTest {
    @Test
    fun test() {
        val bestTimeBuySellStockWithTransactionFee = BestTimeBuySellStockWithTransactionFee()
        bestTimeBuySellStockWithTransactionFee.printDescription()
        assertEquals(8, bestTimeBuySellStockWithTransactionFee.maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2))
    }
}