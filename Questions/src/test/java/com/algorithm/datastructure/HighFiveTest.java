package com.algorithm.datastructure;

import org.junit.Test;

import java.util.Map;

public class HighFiveTest {
    @Test
    public void test() {
        HighFive highFive = new HighFive();
        highFive.printDescription();
        HighFive.Record[] records = new HighFive.Record[10];
        records[0] = new HighFive.Record(1, 91);
        records[1] = new HighFive.Record(1, 92);
        records[2] = new HighFive.Record(2, 93);
        records[3] = new HighFive.Record(2, 99);
        records[4] = new HighFive.Record(2, 98);
        records[5] = new HighFive.Record(2, 97);
        records[6] = new HighFive.Record(1, 60);
        records[7] = new HighFive.Record(1, 58);
        records[8] = new HighFive.Record(2, 100);
        records[9] = new HighFive.Record(1, 61);
        System.out.println("before");
        Map<Integer, Double> map = highFive.highFive(records);
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }
        System.out.println("after");
    }
}
