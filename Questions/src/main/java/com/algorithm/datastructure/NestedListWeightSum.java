package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.List;
import java.util.Stack;

public class NestedListWeightSum implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)\n" +
                "Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4 * 2 + 6 * 3 = 27)\n" +
                "\n");
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        stack.push(new Pair(nestedList, 1));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (NestedInteger ni : p.list) {
                if (ni.isInteger()) {
                    sum += ni.getInteger() * p.depth;
                } else {
                    stack.push(new Pair(ni.getList(), p.depth + 1));
                }
            }
        }
        return sum;
    }

    class Pair {
        List<NestedInteger> list;
        int depth;
        public Pair(List<NestedInteger> list, int depth) {
            this.list = list;
            this.depth = depth;
        }
    }
}
