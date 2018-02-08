package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosetPoints implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.\n" +
                "Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.\n" +
                "Example\n" +
                "Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3\n" +
                "return [[1,1],[2,5],[4,4]]\n" +
                "\n");
    }

    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0) {
            return new Point[]{};
        }
        Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                int d1 = (p1.x - origin.x) * (p1.x - origin.x) + (p1.y - origin.y) * (p1.y - origin.y);
                int d2 = (p2.x - origin.x) * (p2.x - origin.x) + (p2.y - origin.y) * (p2.y - origin.y);
                if (d1 < d2) {
                    return -1;
                } else if (d1 > d2) {
                    return 1;
                } else {
                    if (p2.x > p1.x) {
                        return -1;
                    } else if (p2.x < p1.x) {
                        return 1;
                    } else if (p2.y > p1.y) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for (Point p : points) {
            queue.offer(p);
        }

        Point[] res = new Point[Math.min(k, queue.size())];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
