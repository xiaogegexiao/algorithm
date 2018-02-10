package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.List;

public class MergeKSortedList implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("Merge k sorted linked lists and return it as one sorted list.\n" +
                "\n" +
                "Analyze and describe its complexity.\nExample\n" +
                "Given lists:\n" +
                "\n" +
                "[\n" +
                "  2->4->null,\n" +
                "  null,\n" +
                "  -1->null\n" +
                "],\n" +
                "return -1->2->4->null.\n" +
                "\n");
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return helper(lists, 0, lists.size() - 1);
    }

    ListNode helper(List<ListNode> list, int start, int end) {
        if (start == end) {
            return list.get(start);
        }
        int mid = (end - start) / 2 + start;
        ListNode left = helper(list, start, mid);
        ListNode right = helper(list, mid + 1, end);
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curt.next = left;
                left = left.next;
            } else {
                curt.next = right;
                right = right.next;
            }
            curt = curt.next;
        }
        while (left != null) {
            curt.next = left;
            left = left.next;
            curt = curt.next;
        }
        while (right != null) {
            curt.next = right;
            right = right.next;
            curt = curt.next;
        }
        curt.next = null;
        return dummy.next;
    }
}
