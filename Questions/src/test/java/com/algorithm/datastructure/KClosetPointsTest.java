package com.algorithm.datastructure;

import org.junit.Test;

import java.util.Arrays;

public class KClosetPointsTest {
    @Test
    public void test() {
        KClosetPoints kClosetPoints = new KClosetPoints();
        kClosetPoints.printDescription();

        KClosetPoints.Point[] points = new KClosetPoints.Point[]{
                new KClosetPoints.Point(4, 6),
                new KClosetPoints.Point(4, 7),
                new KClosetPoints.Point(4, 4),
                new KClosetPoints.Point(2, 5),
                new KClosetPoints.Point(1, 1)
        };
        System.out.print(Arrays.toString(kClosetPoints.kClosest(points, new KClosetPoints.Point(0, 0), 3)));
    }
}
