package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighFive implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.\n" +
                "Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]\n" +
                "\n" +
                "Return ");
    }

//    Definition for a Record
static class Record {
        public int id, score;
        public Record(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> map = new HashMap<>();
        if (results == null || results.length < 5) {
            return map;
        }
        Map<Integer, Queue<Integer>> queueMap = new HashMap<>();

        for (Record r : results) {
            if (!queueMap.containsKey(r.id)) {
                queueMap.put(r.id, new PriorityQueue<>());
            }
            Queue<Integer> queue = queueMap.get(r.id);
            queue.offer(r.score);
            if (queue.size() > 5) {
                queue.poll();
            }
        }

        for (Map.Entry<Integer, Queue<Integer>> entry : queueMap.entrySet()) {
            int id = entry.getKey();
            Queue<Integer> queue = entry.getValue();
            if (queue.size() < 5) {
                continue;
            }
            int sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            map.put(id, sum / 5d);
        }
        return map;
    }
}
