package com.algorithm.dynamic_programming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BestTimeToBuyAndSaleStockTest {
    @Test
    public void test() {
        BestTimeToBuyAndSaleStock bestTimeToBuyAndSaleStock = new BestTimeToBuyAndSaleStock();
        bestTimeToBuyAndSaleStock.printDescription();

        assertEquals(bestTimeToBuyAndSaleStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        assertEquals(bestTimeToBuyAndSaleStock.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }
}
