package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class StackBy2Queues implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Implement a stack by two queues. The queue is first in first out (FIFO). That means you can not directly pop the last element in a queue.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "push(1)\n" +
                "pop()\n" +
                "push(2)\n" +
                "isEmpty() // return false\n" +
                "top() // return 2\n" +
                "pop()\n" +
                "isEmpty() // return true");
    }

    Queue<Integer> curtQueue = new LinkedList<>();
    Queue<Integer> backQueue = new LinkedList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        curtQueue.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        while (curtQueue.size() > 1) {
            backQueue.offer(curtQueue.poll());
        }
        curtQueue.poll();
        Queue<Integer> temp = curtQueue;
        curtQueue = backQueue;
        backQueue = temp;
    }

    /*
     * @return: An integer
     */
    public int top() {
        int res = 0;
        while (!curtQueue.isEmpty()) {
            res = curtQueue.poll();
            backQueue.offer(res);
        }
        Queue<Integer> temp = curtQueue;
        curtQueue = backQueue;
        backQueue = temp;
        return res;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return curtQueue.isEmpty();
    }
}
