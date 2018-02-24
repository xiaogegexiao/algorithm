package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.*;

public class TopKFrequentWords implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a list of words and an integer k, return the top k frequent words in the list.\n" +
                "\n" +
                " Notice\n" +
                "You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.\nExample\n" +
                "Given\n" +
                "\n" +
                "[\n" +
                "    \"yes\", \"lint\", \"code\",\n" +
                "    \"yes\", \"code\", \"baby\",\n" +
                "    \"you\", \"baby\", \"chrome\",\n" +
                "    \"safari\", \"lint\", \"code\",\n" +
                "    \"body\", \"lint\", \"code\"\n" +
                "]\n" +
                "for k = 3, return [\"code\", \"lint\", \"baby\"].\n" +
                "\n" +
                "for k = 4, return [\"code\", \"lint\", \"baby\", \"yes\"],\n" +
                "\n" +
                "Challenge \n" +
                "Do it in O(nlogk) time and O(n) extra space.\n" +
                "\n" +
                "Extra points if you can do it in O(n) time with O(k) extra space approximation algorithms.");
    }

    /*
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) > map.get(s2)) {
                    return 1;
                } else if (map.get(s1) < map.get(s2)) {
                    return -1;
                } else {
                    return s2.compareTo(s1);
                }
            }
        });
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        String[] res = new String[queue.size()];
        int index = queue.size() - 1;
        while (!queue.isEmpty()) {
            res[index--] = queue.poll();
        }
        return res;
    }
}
