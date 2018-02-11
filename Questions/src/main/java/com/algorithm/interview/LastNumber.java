package com.algorithm.interview;

import com.algorithm.AlgorithmQuestion;

public class LastNumber implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号");
    }

    public class ListNode {
        int index;
        ListNode next;
        public ListNode(int index) {
            this.index = index;
        }
    }

    public int getLastIndex(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        for (int i = 1; i <= n; i++) {
            curt.next = new ListNode(i);
            curt = curt.next;
        }

        curt.next = dummy.next;
        ListNode prev = null;
        while (curt.next != curt) {
            for (int i = 0; i < 3; i++) {
                prev = curt;
                curt = curt.next;
            }
            prev.next = curt.next;
        }
        return curt.index;
    }
}
